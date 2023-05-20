package com.example.springboot.service;

import com.example.springboot.entity.*;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的 service 层 构建
 * @date 2023/3/9 21:21:52
 */
@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    public List<User> findUsersAdmin(ListQuery query) {
        int page = query.getPage() -1 ;
        int limit = query.getLimit();
        return userMapper.findUsersAdmin(page,limit);
    }

    public int forEachDelete(String id) {
        return userMapper.forEachDelete(id);
    }


    public List<Medicalexaminationfile> fetchMedicalExaminationFile(String userId) {
        return userMapper.fetchMedicalExaminationFile(userId);
    }

    public Healthrecord findHealthRecord(String userId) {
        return userMapper.findHealthRecord(userId);
    }

    public List<Ethnicgroup> healthCareInfoEthnicGroup() {
        return userMapper.healthCareInfoEthnicGroup();
    }

    public List<Bloodtype> healthCareInfoBloodType() {
        return userMapper.healthCareInfoBloodType();
    }

    public List<Education> healthCareInfoEducation() {
        return userMapper.healthCareInfoEducation();
    }

    public List<Marriage> healthCareInfoMarriage() {
        return userMapper.healthCareInfoMarriage();
    }

    public List<Pamentmeth> healthCareInfoPamentMeth() {
        return userMapper.healthCareInfoPamentMeth();
    }

    public List<Allergyhistory> healthCareInfoAllergyHistory() {
        return userMapper.healthCareInfoAllergyHistory();
    }

    public List<Work> healthCareInfoWorks() {
        return userMapper.healthCareInfoWorks();
    }

    public List<Sex> healthCareInfoSex() {
        return userMapper.healthCareInfoSex();
    }

    public List<User> findUserByNickName(String title) {
        return userMapper.findUserByNickName(title);
    }
}
