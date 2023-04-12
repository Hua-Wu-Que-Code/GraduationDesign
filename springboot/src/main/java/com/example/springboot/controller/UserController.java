package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.UserVO;
import com.example.springboot.jwt.JwtUtil;
import com.example.springboot.mapper.RoleMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result login(@RequestBody User userParam) {

        //查找用户
        User logInUser = userService.findUserByUserName(userParam.getUsername());

        //判断密码是否正确
        if (!logInUser.getPassword().equals(userParam.getPassword())) {
            return Result.fail("密码错误");
        }
        if (logInUser == null ) return Result.fail("用户名或密码错误");

       /* HashSet<Permission> permissionSet = new HashSet<>();
        //1.获取角色信息
        logInUser = userService.findUserById(logInUser.getId());
        List<UserRole> userRoles = userRoleService.findRoleId(logInUser.getId());
        //设置角色id
        logInUser.setRoles(userRoles.stream().map(UserRole::getRoleId).distinct().collect(Collectors.toList()));
        for (UserRole userRole:userRoles) {
            // 2.根据roleId从role_permission表查询出所有的permissionId
            List<RolePermission> rolePermissions = permissionMapper.getRolePermissionByRoleId(userRole.getRoleId());
            for (RolePermission rolePermission : rolePermissions) {
                Integer permissionId = rolePermission.getPermissionId();
                // 3. 根据permissionId查询permission信息
                Permission permission = permissionMapper.selectById(permissionId);
                permissionSet.add(permission);
            }
        }
        // 对资源根据id进行排序
        LinkedHashSet<Permission> sortedSet = permissionSet.stream().sorted(Comparator.comparing(Permission::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
        //设置当前用户的资源信息
        logInUser.setPermissions(sortedSet);
        UserVO userVO = new UserVO(JwtUtil.generateToken(logInUser.getId()),logInUser);*/
        logInUser = userService.findUserById(logInUser.getId());
        return Result.succeed(JwtUtil.generateToken(logInUser.getId()));
    }

    /**
     * 获取用户最新信息
     * @return
     */
    @RequestMapping("/info")
    @CrossOrigin
    @ResponseBody
    public Result getInfo() {

        String id = (String) request.getAttribute("id");

        if (id != null) {
            //获取角色信息
            User user = userService.findUserById(id);
            Integer roleId = user.getRoleid();
            List<String> roleList = roleMapper.findRole(roleId);
            user.setRoles(roleList);
            UserVO userVO = UserVO.builder().
                    roles(user.getRoles()).
                    name(user.getNickname()).
                    avatar(user.getAvatar()).
                    build();
            return Result.succeed(userVO);
        }
        return Result.fail("请重新登陆");

    }
}
