package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.HealthCareInfo;
import com.example.springboot.entity.eneityVO.UserInfo;
import com.example.springboot.mapper.DoctorMapper;
import com.example.springboot.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 获取医生辖区内居民
     * @return
     */
    @RequestMapping("/patientList")
    @CrossOrigin
    @ResponseBody
    public Result patientList(@RequestBody ListQuery query) {
        String doctorId = (String) request.getAttribute("id");
        ArrayList<Patient> patients = new ArrayList<>();
        if (query.getType().equals("name")) {
            String title = query.getTitle();
            List<User> users = userService.findUserByNickName(title);
            ArrayList<Patient> p = new ArrayList<>();
            users.forEach(u -> {
                ArrayList<Patient> p1 = doctorMapper.searchExam(query.getPage()-1,query.getLimit(),doctorId,u.getId());
                p.addAll(p1);
            });
            patients.addAll(p);
        } else {
            patients = doctorMapper.patientList(query.getPage()-1,query.getLimit(),doctorId);
        }
        ArrayList<Patient> allPatients = doctorMapper.allPatientList(doctorId);
        //健康表信息
        HealthCareInfo healthCareInfo = new HealthCareInfo();


        //获取民族列表
        List<Ethnicgroup> ethnicgroups = userService.healthCareInfoEthnicGroup();
        healthCareInfo.setEthnicgroup(ethnicgroups);
        //获取血型列表
        List<Bloodtype> bloodtypes = userService.healthCareInfoBloodType();
        healthCareInfo.setBloodtype(bloodtypes);
        //获取教育情况列表
        List<Education> educations = userService.healthCareInfoEducation();
        healthCareInfo.setEducation(educations);
        //获取婚姻状况列表
        List<Marriage> marriages = userService.healthCareInfoMarriage();
        healthCareInfo.setMarriage(marriages);
        //获取支付方式列表
        List<Pamentmeth> pamentmeths = userService.healthCareInfoPamentMeth();
        healthCareInfo.setPamentmeth(pamentmeths);
        //获取过敏列表
        List<Allergyhistory> allergyhistories = userService.healthCareInfoAllergyHistory();
        healthCareInfo.setAllergyhistory(allergyhistories);
        //获取工作列表
        List<Work> works = userService.healthCareInfoWorks();
        healthCareInfo.setWorks(works);
        //获取性别列表
        List<Sex> sexes = userService.healthCareInfoSex();
        healthCareInfo.setSexes(sexes);
        //获取疾病列表
        List<Disease> diseases = commonMapper.healthCareInfoDisease();
        healthCareInfo.setDiseases(diseases);
        //获取残疾列表
        List<Disability> disabilities = commonMapper.healthCareInfoUserDisability();
        healthCareInfo.setDisabilities(disabilities);
        //获取遗传病列表
        List<HeritageDisease> heritageDiseases = commonMapper.healthCareInfoHeritageDisease();
        healthCareInfo.setHeritageDiseases(heritageDiseases);
        patients.forEach(item->{
            String userId = item.getId();
            item.setSexStr(commonMapper.userInfoSex(item.getSex()));
            item.setGroupStr(commonMapper.userInfoEthnicGroup(item.getGroupid()));
            //体检信息
            List<Medicalexaminationfile> medicalexaminationfiles = userService.fetchMedicalExaminationFile(userId);
            //健康表
            Healthrecord healthrecord = userService.findHealthRecord(userId);
            //用户信息
            UserInfo userInfo = new UserInfo();

            //如果没有基本健康表
            if (healthrecord != null) {
                //获取用户疾病历史
                List<UserDisease> userDiseases = commonMapper.userInfoUserDisease(userId);
                List<String> diseasesUser = new ArrayList<String>();
                for (UserDisease userDisease:userDiseases) {
                    for (Disease disease:diseases) {
                        if (disease.getId() == userDisease.getDiseaseid())
                            diseasesUser.add(disease.getName());
                    }
                }
                healthrecord.setDiseases(diseasesUser);

                //获取用户残疾历史
                List<UserDisability> userDisabilities = commonMapper.userInfoUserDisability(userId);
                List<String> disabilityUser = new ArrayList<String>();
                for (UserDisability userDisability:userDisabilities) {
                    for (Disability disability:disabilities) {
                        if (disability.getId() == userDisability.getDisabilityid())
                            disabilityUser.add(disability.getName());
                    }
                }
                healthrecord.setDisabilities(disabilityUser);

                //获取用户过敏历史
                List<UserAllergy> userAllergies = commonMapper.userInfoUserAllergy(userId);
                List<String> allergyUser = new ArrayList<>();
                for (UserAllergy userAllergy:userAllergies) {
                    for (Allergyhistory allergyhistory:allergyhistories) {
                        if (allergyhistory.getId() == userAllergy.getAllergyid()) {
                            allergyUser.add(allergyhistory.getName());
                        }
                    }
                }
                healthrecord.setAllergyhistory(allergyUser);

                //获取用户遗传病历史
                List<UserHeritage> userHeritages = commonMapper.userInfoUserHeritage(userId);
                List<String> heritageUser = new ArrayList<>();
                for (UserHeritage userHeritage:userHeritages) {
                    for (HeritageDisease heritageDisease:heritageDiseases) {
                        if (userHeritage.getHeritageid() == heritageDisease.getId()) {
                            heritageUser.add(heritageDisease.getName());
                        }
                    }
                }
                healthrecord.setHeredityhistory(heritageUser);

                //记录用户血型
                healthrecord.setBloodType(commonMapper.userInfoBloodType(healthrecord.getBloodtypeid()));
                //记录用户教育水平
                healthrecord.setEducation(commonMapper.userInfoEducation(healthrecord.getEducationid()));
                //记录用户民族
                healthrecord.setEthnicGroup(commonMapper.userInfoEthnicGroup(healthrecord.getEthnicgroupid()));
                //记录用户支付方式
                healthrecord.setPamentmeth(commonMapper.userInfoPamentMeth(healthrecord.getPamentmethid()));
                //记录用户婚姻状况
                healthrecord.setMarriage(commonMapper.userInfoMarrage(healthrecord.getMarriageid()));
                //记录用户性别
                healthrecord.setSex(commonMapper.userInfoSex(healthrecord.getSexid() ));
                //记录用户工作
                healthrecord.setWork(commonMapper.userInfoWork(healthrecord.getWorkid()));
            } else {
                healthrecord = new Healthrecord();
                healthrecord.setName(commonMapper.getUserName(userId));
                healthrecord.setUserid(userId);
            }
            /*userInfo.setHealthCareInfo(healthCareInfo);*/


            userInfo.setHealthrecord(healthrecord);
            userInfo.setMedicalexaminationfile(medicalexaminationfiles);

            item.setUserInfo(userInfo);
        });

        Map map = new HashMap();
        map.put("healthCareInfo",healthCareInfo);
        map.put("total",allPatients.size());
        map.put("list",patients);


        return Result.succeed(map);
    }

    /**
     * 获取健康表信息
     * @return
     */
    @RequestMapping("/healthCareInfo")
    @CrossOrigin
    @ResponseBody
    public Result healthCareInfo() {
        //健康表信息
        HealthCareInfo healthCareInfo = new HealthCareInfo();


        //获取民族列表
        List<Ethnicgroup> ethnicgroups = userService.healthCareInfoEthnicGroup();
        healthCareInfo.setEthnicgroup(ethnicgroups);
        //获取血型列表
        List<Bloodtype> bloodtypes = userService.healthCareInfoBloodType();
        healthCareInfo.setBloodtype(bloodtypes);
        //获取教育情况列表
        List<Education> educations = userService.healthCareInfoEducation();
        healthCareInfo.setEducation(educations);
        //获取婚姻状况列表
        List<Marriage> marriages = userService.healthCareInfoMarriage();
        healthCareInfo.setMarriage(marriages);
        //获取支付方式列表
        List<Pamentmeth> pamentmeths = userService.healthCareInfoPamentMeth();
        healthCareInfo.setPamentmeth(pamentmeths);
        //获取过敏列表
        List<Allergyhistory> allergyhistories = userService.healthCareInfoAllergyHistory();
        healthCareInfo.setAllergyhistory(allergyhistories);
        //获取工作列表
        List<Work> works = userService.healthCareInfoWorks();
        healthCareInfo.setWorks(works);
        //获取性别列表
        List<Sex> sexes = userService.healthCareInfoSex();
        healthCareInfo.setSexes(sexes);
        //获取疾病列表
        List<Disease> diseases = commonMapper.healthCareInfoDisease();
        healthCareInfo.setDiseases(diseases);
        //获取残疾列表
        List<Disability> disabilities = commonMapper.healthCareInfoUserDisability();
        healthCareInfo.setDisabilities(disabilities);
        //获取遗传病列表
        List<HeritageDisease> heritageDiseases = commonMapper.healthCareInfoHeritageDisease();
        healthCareInfo.setHeritageDiseases(heritageDiseases);
        return Result.succeed(healthCareInfo);
    }

    /**
     * 获取健康表信息
     * @return
     */
    @RequestMapping("/updateHealthCard")
    @CrossOrigin
    @ResponseBody
    public Result updateHealthCard(@RequestBody Map map) {


        Object map1 = new Object();
        map1 =  map.get("healthCare");
        String s = JSON.toJSONString(map1);
        Healthrecord healthrecord = JSON.parseObject(s,Healthrecord.class);
        Healthrecord h1 = commonMapper.findHealthCordByUserId(healthrecord.getUserid());

        if (h1 == null) {
            healthCardMapper.insert(healthrecord);
        } else {
            healthrecord.setId(h1.getId());
            healthCardMapper.update(healthrecord);
        }
        return Result.succeed("成功");



    }

}
