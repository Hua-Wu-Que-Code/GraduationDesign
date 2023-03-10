package com.example.springboot.controller;

import com.example.springboot.entity.Result;
import com.example.springboot.entity.User;
import com.example.springboot.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的控制类
 * @date 2023/3/9 22:31:10
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * 用户登陆类
     * @return 登陆结果
     */
    @RequestMapping("/login")
    @CrossOrigin
    @ResponseBody
    public Result login(@RequestBody User user) {

        System.out.println(user.getUsername());
        User logInUser = userService.findUserByUserName(user.getUsername());
        if (logInUser != null && logInUser.getPassword().equals(user.getPassword())) {
            return Result.succeed(JwtUtil.generateToken(logInUser.getId()));
        }
        return Result.fail("登陆失败");

    }
}
