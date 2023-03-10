package com.example.springboot.controller;

import com.example.springboot.entity.Result;
import com.example.springboot.entity.User;
import com.example.springboot.entity.eneityVO.UserVO;
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
     * 用户登陆
     * @return 登陆结果
     */
    @RequestMapping("/login")
    @CrossOrigin
    @ResponseBody
    public Result login(@RequestBody User user) {

        User logInUser = userService.findUserByUserName(user.getUsername());
        if (logInUser != null && logInUser.getPassword().equals(user.getPassword())) {
            logInUser = userService.findUserById(logInUser.getId());
            UserVO userVO = new UserVO(JwtUtil.generateToken(logInUser.getId()),logInUser);
            return Result.succeed(userVO);
        }
        return Result.fail("登陆失败");

    }

    /**
     * 获取用户最新信息
     * @return
     */
    @RequestMapping("/upgrade")
    @CrossOrigin
    @ResponseBody
    public Result upgrade() {

        String id = (String) request.getAttribute("id");

        if (id != null) {
            return Result.succeed(userService.findUserById(id));
        }
        return Result.fail("请重新登陆");

    }
}
