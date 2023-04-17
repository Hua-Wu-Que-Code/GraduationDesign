package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.*;
import com.example.springboot.jwt.JwtUtil;
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
            List<String> roleList = roleMapper.findRoleName(roleId);
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


    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result getUserList(@RequestBody ListQuery query) {
        List<User> userList = userService.findUsersAdmin(query);
        userList.forEach(user -> {
            Integer roleId = user.getRoleid();
            List<String> roleList = roleMapper.findRoleIntroduction(roleId);
            user.setRoles(roleList);
        });

        return Result.succeed(userList);
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    @CrossOrigin
    @ResponseBody
    public Result fetchHealthCare(@RequestBody User userParam) {

        String id = userParam.getId();
        int flag = userService.forEachDelete(id);
        return Result.succeed(flag);
    }

    /**
     * 查询用户健康档案
     * @return
     */
    @RequestMapping("/fetchMedicalExaminationFile")
    @CrossOrigin
    @ResponseBody
    public Result forEachDelete(@RequestBody User userParam) {

        String userId = userParam.getId();
        List<Medicalexaminationfile> medicalexaminationfiles = userService.fetchMedicalExaminationFile(userId);
        Healthrecord healthrecord = userService.findHealthRecord(userId);
        UserInfo userInfo = new UserInfo();
        List<Ethnicgroup> ethnicgroups = userService.healthCareInfoEthnicGroup();
        List<Bloodtype> bloodtypes = userService.healthCareInfoBloodType();
        List<Education> educations = userService.healthCareInfoEducation();
        List<Marriage> marriages = userService.healthCareInfoMarriage();
        List<Pamentmeth> pamentmeths = userService.healthCareInfoPamentMeth();
        List<Allergyhistory> allergyhistories = userService.healthCareInfoAllergyHistory();

        userInfo.setHealthrecord(healthrecord);
        userInfo.setMedicalexaminationfile(medicalexaminationfiles);

        HealthCareInfo healthCareInfo = new HealthCareInfo();
        healthCareInfo.setEthnicgroup(ethnicgroups);
        healthCareInfo.setBloodtype(bloodtypes);
        healthCareInfo.setEducation(educations);
        healthCareInfo.setMarriage(marriages);
        healthCareInfo.setPamentmeth(pamentmeths);
        healthCareInfo.setAllergyhistory(allergyhistories);

        userInfo.setHealthCareInfo(healthCareInfo);

        return Result.succeed(userInfo);
    }

}
