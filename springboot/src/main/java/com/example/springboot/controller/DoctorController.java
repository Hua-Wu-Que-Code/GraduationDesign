package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.mapper.DoctorMapper;
import com.example.springboot.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 医生控制类
 * @date 2023/5/15 19:04:42
 */

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController {
    /**
     * 获取医生列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result getUserList(@RequestBody ListQuery query) {
        List<Doctor> doctorsList = doctorService.findDoctorsAdmin(query);
        for (Doctor doctor:doctorsList) {
            String id  = doctor.getId();
            User d = userService.findUserById(id);
            String sta = d.isStatus() ? "正常" : "停用";
            d.setStatusStr(sta);
            Integer roleId = d.getRoleid();
            List<String> roleList = roleMapper.findRoleIntroduction(roleId);
            d.setRoles(roleList);
            doctor.setDoctor(d);




            String clinicId = commonMapper.findClinicByDoctorId(id);
            Clinic clinic = clinicService.findClinicById(clinicId);
            //修改诊所地址
            int addressID = commonMapper.findAddressIDByUserId(clinicId);
            Address address = commonMapper.findAddressByID(addressID);
            clinic.setAddress(address);
            doctor.setClinic(clinic);


        }
        return Result.succeed(doctorsList);
    }
}
