package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.*;
import com.example.springboot.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        //体检信息
        List<Medicalexaminationfile> medicalexaminationfiles = userService.fetchMedicalExaminationFile(userId);
        Healthrecord healthrecord = userService.findHealthRecord(userId);
        //用户信息
        UserInfo userInfo = new UserInfo();
        //健康报信息
        HealthCareInfo healthCareInfo = new HealthCareInfo();


        //获取民族列表
        List<Ethnicgroup> ethnicgroups = userService.healthCareInfoEthnicGroup();
        healthCareInfo.setEthnicgroup(ethnicgroups);
        //获取血型列表
        List<Bloodtype> bloodtypes = userService.healthCareInfoBloodType();
        healthCareInfo.setBloodtype(bloodtypes);
        //获取教育情况列表
        List<Education> educations = userService.healthCareInfoEducation();
        healthCareInfo.setEducation(educations);
        //获取婚姻状况列表
        List<Marriage> marriages = userService.healthCareInfoMarriage();
        healthCareInfo.setMarriage(marriages);
        //获取支付方式列表
        List<Pamentmeth> pamentmeths = userService.healthCareInfoPamentMeth();
        healthCareInfo.setPamentmeth(pamentmeths);
        //获取过敏列表
        List<Allergyhistory> allergyhistories = userService.healthCareInfoAllergyHistory();
        healthCareInfo.setAllergyhistory(allergyhistories);
        //获取工作列表
        List<Work> works = userService.healthCareInfoWorks();
        healthCareInfo.setWorks(works);
        //获取性别列表
        List<Sex> sexes = userService.healthCareInfoSex();
        healthCareInfo.setSexes(sexes);
        //获取疾病列表
        List<Disease> diseases = commonMapper.healthCareInfoDisease();
        healthCareInfo.setDiseases(diseases);
        //获取残疾列表
        List<Disability> disabilities = commonMapper.healthCareInfoUserDisability();
        healthCareInfo.setDisabilities(disabilities);


        //获取用户疾病历史
        List<UserDisease> userDiseases = commonMapper.userInfoUserDisease(userId);
        List<String> diseasesUser = new ArrayList<String>();
        for (UserDisease userDisease:userDiseases) {
            for (Disease disease:diseases) {
                if (disease.getId() == userDisease.getDiseaseid())
                    diseasesUser.add(disease.getName());
            }
        }
        healthrecord.setDiseases(diseasesUser);

        //获取用户残疾历史
        List<UserDisability> userDisabilities = commonMapper.userInfoUserDisability(userId);
        List<String> disabilityUser = new ArrayList<String>();
        for (UserDisability userDisability:userDisabilities) {
            for (Disability disability:disabilities) {
                if (disability.getId() == userDisability.getDisabilityid())
                    disabilityUser.add(disability.getName());
            }
        }
        healthrecord.setDisabilities(disabilityUser);


        userInfo.setHealthCareInfo(healthCareInfo);
        userInfo.setHealthrecord(healthrecord);
        userInfo.setMedicalexaminationfile(medicalexaminationfiles);

        return Result.succeed(userInfo);
    }

}
