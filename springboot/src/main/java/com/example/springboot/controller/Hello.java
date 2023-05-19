package com.example.springboot.controller;

import com.example.springboot.entity.Drug;
import com.example.springboot.entity.UserDisability;
import com.example.springboot.mapper.ClinicMapper;
import com.example.springboot.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/*
*   测试程序是否能够运行
* */

@RestController
@RequestMapping("/test")
public class Hello extends BaseController{

    @RequestMapping("/hello")
    @ResponseBody
    public UserDisability category() {
        String userId = "b3ed4f7b-0d55-4afa-85b7-e629d58d5eb2";
        List<UserDisability> userDisabilities = commonMapper.userInfoUserDisability(userId);
        return userDisabilities.get(0);
    }

    @Autowired
    SupplierMapper supplierMapper;

    @RequestMapping("/insertSupplierDrug")
    @ResponseBody
    public void insertSupperDrug() {

        ArrayList<Drug> drugs = drugMapper.findAllDrugs();
        drugs.forEach(item-> {
            supplierMapper.InsertSupplierDrug("df1f1613-bdc5-48f4-b2ae-f8e523c19b42",item.getDrugid(),0,10.88);
        });
    }

    @Autowired
    ClinicMapper clinicMapper;

    @RequestMapping("/insertClinicDrug")
    @ResponseBody
    public void insertClinicDrug() {

        ArrayList<Drug> drugs = drugMapper.findAllDrugs();
        drugs.forEach(item-> {
            clinicMapper.insertClinicDrug("c298dd18-828d-4a34-8287-0099eccca7eb",item.getDrugid(),10);
        });
    }


}
