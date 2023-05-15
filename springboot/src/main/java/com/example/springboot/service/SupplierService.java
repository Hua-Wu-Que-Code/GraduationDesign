package com.example.springboot.service;

import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.Supplier;
import com.example.springboot.mapper.DoctorMapper;
import com.example.springboot.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 供货商服务层
 * @date 2023/5/15 20:00:31
 */
@Service
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    public List<Supplier> findSuppliersAdmin(ListQuery query) {
        int page = query.getPage() -1 ;
        int limit = query.getLimit();
        return supplierMapper.findSuppliersAdmin(page,limit);
    }
}
