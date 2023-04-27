package com.example.springboot.service;

import com.example.springboot.entity.Clinic;
import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.ClinicMapper;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 诊所的实现层
 * @date 2023/4/27 15:27:25
 */
@Service
public class ClinicService {
    @Autowired
    ClinicMapper clinicMapper;
    public List<Clinic> findClinicAdmin(ListQuery query) {
        int page = query.getPage() -1 ;
        int limit = query.getLimit();
        return clinicMapper.findClinicAdmin(page,limit);
    }
}
