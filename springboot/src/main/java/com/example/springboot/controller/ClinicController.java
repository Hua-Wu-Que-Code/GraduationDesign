package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.service.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 诊所的控制类
 * @date 2023/4/27 15:24:24
 */
@RestController
@RequestMapping("/clinic")
public class ClinicController extends BaseController{

    /**
     * 获取诊所列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result fetchClinicList(@RequestBody ListQuery query) {

        List<Clinic> clinicList = clinicService.findClinicAdmin(query);
        clinicList.forEach(clinic -> {
            String id = clinic.getId();
            String DoctorID = commonMapper.findDoctorByClinicId(id);
            Doctor doctor = doctorMapper.findDoctorByID(DoctorID);
            User user = userService.findUserById(doctor.getId());
            Integer roleId = user.getRoleid();
            List<String> roleList = roleMapper.findRoleIntroduction(roleId);
            user.setRoles(roleList);
            doctor.setDoctor(user);
            clinic.setDoctor(doctor);
        });
        return Result.succeed(clinicList);
    }
}
