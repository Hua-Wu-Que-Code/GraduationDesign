package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.ExamInfo;
import com.example.springboot.mapper.MedicalexaminationfileMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 体检详情控制表
 * @date 2023/5/19 13:42:05
 */
@RestController
@RequestMapping("/exam")
public class ExamController extends BaseController{

    /**
     * 获取体检详细信息
     * @return
     */
    @RequestMapping("/detail")
    @CrossOrigin
    @ResponseBody
    public Result getUserList(@RequestBody ListQuery query) {
        Exam exam = examMapper.findExamById(query.getLimit());

        ExamInfo examInfo = examInfoService.findDetailInfo();
        Map map = new HashMap();
        map.put("exam",exam);
        map.put("examInfo",examInfo);
        return Result.succeed(map);
    }

    /**
     * 获取体检资料
     * @return
     */
    @RequestMapping("/findDetailInfo")
    @CrossOrigin
    @ResponseBody
    public Result findDetailInfo() {

        ExamInfo examInfo = examInfoService.findDetailInfo();
        Map map = new HashMap();
        map.put("examInfo",examInfo);
        return Result.succeed(map);
    }

    /**
     * 新增体检
     * @return
     */
    @RequestMapping("/insert")
    @CrossOrigin
    @ResponseBody
    public Result insertDetail(@RequestBody Map map) {
        Object map1 = new Object();
        map1 =  map.get("data");
        String s = JSON.toJSONString(map1);
        Exam exam = JSON.parseObject(s,Exam.class);

        String doctorId = (String) request.getAttribute("id");
        Doctor doctor = doctorMapper.findDoctorByID(doctorId);
        String doctorName = doctor.getName();
        exam.setDoctorid(doctorId);
        exam.setDoctorname(doctorName);
        Medicalexaminationfile medicalexaminationfile = new Medicalexaminationfile();
        medicalexaminationfile.setDate(exam.getDate());


        String clinicId = commonMapper.findClinicByDoctorId(doctorId);
        Clinic clinic = clinicService.findClinicById(clinicId);
        examMapper.insert(exam);
        int examId = examMapper.findExamIdByDate(exam.getDate(),exam.getUserid(),exam.getDoctorid());

        String userId = exam.getUserid();
        User user = userService.findUserById(userId);

        medicalexaminationfile.setNickname(user.getNickname());
        medicalexaminationfile.setSrc(clinic.getAvatar());
        medicalexaminationfile.setDescription(exam.getDate()+"于"+clinic.getName()+"进行体检");
        medicalexaminationfile.setDetailinfo(examId);
        medicalexaminationfile.setClincid(clinicId);
        medicalexaminationfile.setUserid(userId);
        medicalexaminationfileMapper.insert(medicalexaminationfile);
        return Result.succeed("成功");
    }



}
