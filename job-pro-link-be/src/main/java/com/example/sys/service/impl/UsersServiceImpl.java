package com.example.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.APIException;
import com.example.sys.entity.Users;
import com.example.sys.mapper.UsersMapper;
import com.example.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(Users user) {
        //メールアドレスでデータベースを検索
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getEmail, user.getEmail());
        Users loginUser = this.baseMapper.selectOne(wrapper);
        //token生成し、ユーザー情報をredisに保存する
        if (loginUser != null && passwordEncoder.matches(user.getPassword(), loginUser.getPassword())) {
            Map<String, Object> data = new HashMap<>();
            String key = "user::" + UUID.randomUUID();
            data.put("token", key);
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        //tokenに基づいてユーザー情報を取得する
        Object obj = redisTemplate.opsForValue().get(token);
        // デシリアライズ
        Users loginUser = JSON.parseObject(JSON.toJSONString(obj),Users.class);
        if(loginUser != null){
            Map<String, Object> data =  new HashMap<>();
            data.put("username",loginUser.getUserName());
            data.put("icon",loginUser.getIcon());
            return data;
        }
        return null;
    }

    @Override
    public String nameValidation(String userName) {
        return this.baseMapper.getUserName(userName);
    }

    @Override
    public String passwordValidation(String password) {
        return this.baseMapper.getPassword(password);
    }

    @Override
    public boolean saveData(Users user) {
        //データの再チェック
        String checkName = nameValidation(user.getUserName());
        if(checkName!=null){ throw new APIException("ユーザー名は既にあります。");}
        String checkPassword = passwordValidation(user.getPassword());
        if(checkPassword!=null){throw new APIException("パスワードは既にあります。");}
        //データを追加する
        return save(user);
    }

}
