package com.example.sys.service;

import com.example.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
public interface IUsersService extends IService<Users> {
    Map<String, Object> login(Users user);

    Map<String, Object> getUserInfo(String token);

    String nameValidation(String userName);

    String passwordValidation(String password);

   boolean saveData(Users user);
}
