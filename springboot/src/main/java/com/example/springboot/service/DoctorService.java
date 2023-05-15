package com.example.springboot.service;

import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 医生服务层
 * @date 2023/5/15 19:07:55
 */
@Service
public class DoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    public List<Doctor> findDoctorsAdmin(ListQuery query) {
        int page = query.getPage() -1 ;
        int limit = query.getLimit();
        return doctorMapper.findDoctorsAdmin(page,limit);
    }
}
