package com.example.springboot.controller;

import com.example.springboot.entity.Clinic;
import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.Result;
import com.example.springboot.entity.User;
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
     * 删除用户
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result fetchClinicList(@RequestBody ListQuery query) {

        List<Clinic> clinicList = clinicService.findClinicAdmin(query);
        clinicList.forEach(clinic -> {
            clinic.setDoctor(doctorMapper.findDoctorByID(clinic.getDortorid()));
        });
        return Result.succeed(clinicList);
    }
}
