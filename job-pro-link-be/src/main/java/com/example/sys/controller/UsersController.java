package com.example.sys.controller;


import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.sys.entity.Users;
import com.example.sys.service.IUsersService;
import com.example.sys.vo.UsersAddReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
@RestController
@RequestMapping
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/login")
    public Result<Map<String,Object>> login(@RequestBody Users user){
    Map<String,Object> data=usersService.login(user);
    if(data != null){
        return Result.success(data);
    }
        return Result.result(ResultCode.LOGIN_FAILED);
    }

    @GetMapping("/user/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
        //tokenに基づいてユーザー情報を取得する
        Map<String,Object> data=usersService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.result(ResultCode.INVALID_TOKEN_ERROR);
    }

//ユーザー名が存在するかを確認する
    @PostMapping("/register/talent/name/validation")
    public Result<?> getUserName(@RequestBody String userName){
        String data= usersService.nameValidation(userName);
        if(data != null){
            return Result.result(ResultCode.NAME_VALIDATE_ERROR);
        }
        return Result.success();
    }
    //パスワードが存在するかを確認する
    @PostMapping("/register/talent/password/validation")
    public Result<?> getPassword(@RequestBody String password){
        String data= usersService.passwordValidation(password);
        if(data != null){
            return Result.result(ResultCode.PASSWORD_VALIDATE_ERROR);
        }
        return Result.success();
    }

    @PostMapping("/register/talent")
    public Result<?> talentRegister(@Validated @RequestBody UsersAddReq req){
        Users user = new Users();
        BeanUtils.copyProperties(req,user);
        //JSON parse error: Cannot deserialize instance of `java.lang.String` out of START_ARRAY token；
        if(req.getSkills()!=null){user.setSkills(req.getSkills().toJSONString());}
        if(req.getLanguages()!=null){user.setLanguages(req.getLanguages().toJSONString());}
        if(req.getProjectHistories()!=null){user.setProjectHistories(req.getProjectHistories().toJSONString());}
        if(req.getWorkHistories()!=null){user.setWorkHistories(req.getWorkHistories().toJSONString());}
        if(req.getCourses()!=null){user.setCourses(req.getCourses().toJSONString());}

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        boolean saveResult = usersService.saveData(user);
        if(saveResult){
            return Result.success(user.getUserId());
        }
        return Result.result(ResultCode.REGISTER_FAILED);
    }
}
