package com.example.springboot.controller;

import com.example.springboot.entity.*;
import com.example.springboot.service.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

            //修改诊所地址
            int addressID = commonMapper.findAddressIDByUserId(id);
            Address address = commonMapper.findAddressByID(addressID);
            clinic.setAddress(address);

            int start = clinic.getStartTime();
            int end = clinic.getCloseTime();
            ArrayList<Schedule> time = new ArrayList<>();
            time.add(commonMapper.findScheduleById(start));
            time.add(commonMapper.findScheduleById(end));
            clinic.setTime(time);

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minutes = calendar.get(Calendar.MINUTE);

            String status = "休息中";

            if ( hour >= Integer.parseInt(time.get(0).getHours() ) && minutes >= Integer.parseInt(time.get(0).getMinutes())) {
                if (hour <= Integer.parseInt(time.get(1).getHours()) && minutes <= Integer.parseInt(time.get(1).getMinutes()) ) {
                    status = "营业中";
                }
            }
            clinic.setStatus(status);
        });
        return Result.succeed(clinicList);
    }
}
