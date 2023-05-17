package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.ListVo;

import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 药品控制类
 * @date 2023/5/17 00:54:59
 */
@RestController
@RequestMapping("/drug")
public class DrugController extends BaseController{
    /**
     * 添加药品
     * @return
     */
    @RequestMapping("/add")
    @CrossOrigin
    @ResponseBody
    public Result addDrugList(@RequestBody Map map) {
        ArrayList<Drug> drugArray = (ArrayList<Drug>) map.get("json");
        String s = JSON.toJSONString(drugArray);
        List<Drug> drugList = JSONObject.parseArray(s, Drug.class);

        for (int i = 0;i<drugList.size();i++) {


            drugMapper.insertDrug(drugList.get(i).getDrugid(),drugList.get(i).getDrugname(),drugList.get(i).getManu(),drugList.get(i).getPzwh(),drugList.get(i).getClassifyid());
        }

        return Result.succeed();
    }

    /**
     * 添加药品类别
     * @return
     */
    @RequestMapping("/addClass")
    @CrossOrigin
    @ResponseBody
    public Result addDrugClass(@RequestBody Map map) {
        ArrayList<Drugclass> drugArray = (ArrayList<Drugclass>) map.get("json");
        String s = JSON.toJSONString(drugArray);
        List<Drugclass> drugList = JSONObject.parseArray(s, Drugclass.class);

        for (int i = 0;i<drugList.size();i++) {
            drugMapper.insertDrugClass(drugList.get(i).getClassname(),drugList.get(i).getClassify(),drugList.get(i).getClassifyid());
        }

        return Result.succeed();
    }

    /**
     * 添加药品详细信息
     * @return
     */
    @RequestMapping("/addDetail")
    @CrossOrigin
    @ResponseBody
    public Result addDrugDetail(@RequestBody Map map) {
        Object map1 = new Object();
        map1 = map.get("drug");
        String s = JSON.toJSONString(map1);
        DrugInfo drugInfo = JSONObject.parseObject(s,DrugInfo.class);
        String drugId = UUID.randomUUID().toString();
        drugInfo.setDrugid(UUID.randomUUID().toString());
        String drugName = drugInfo.getDrugName();
        String jj = drugInfo.getJj();
        String xz = drugInfo.getXz();
        String spmc = drugInfo.getSpmc();
        String jx = drugInfo.getJx();
        String syz = drugInfo.getSyz();
        String yfyl = drugInfo.getYfyl();
        String zycf = drugInfo.getZycf();
        String zysx = drugInfo.getZysx();
        String etyy = drugInfo.getEtyy();
        String gg = drugInfo.getGg();
        String yfjbrqfnyy = drugInfo.getYfjbrqfnyy();
        String manu = drugInfo.getManu();
        String zc = drugInfo.getZc();
        String hypy = drugInfo.getHypy();
        String tymc = drugInfo.getTymc();
        String pzwh = drugInfo.getPzwh();
        String zxbz = drugInfo.getZxbz();
        String ywxhzy = drugInfo.getYwxhzy();
        String yxq = drugInfo.getYxq();
        String blfy = drugInfo.getBlfy();
        String lryy = drugInfo.getLryy();
        String price = drugInfo.getPrice();
        drugMapper.insertDrugInfo(drugId,drugName,jj,gg,xz,spmc,jx,syz,yfyl,zycf,zysx,etyy,yfjbrqfnyy,manu,zc,hypy,tymc,pzwh,zxbz,ywxhzy,yxq,blfy,lryy,price);

        return Result.succeed();
    }


    /**
     * 获取药品列表
     * @return
     */
    @RequestMapping("/list")
    @CrossOrigin
    @ResponseBody
    public Result getDrugList(@RequestBody ListQuery query) {
        ArrayList<Drug> drugList = drugMapper.findDrugsAdmin(query);
        drugList.forEach(item-> {
            if (item.getStatus() == 0) item.setStatusStr("正常");
            else item.setStatusStr("停用");
            String classifyid = item.getClassifyid();
            item.setDrugclass(drugMapper.findClassById(classifyid));
        });
        ListVo listVo = new ListVo(drugMapper.total(),drugList);
        return Result.succeed(listVo);
    }
    /**
     * 获取药品详情
     * @return
     */
    @RequestMapping("/drugDetail")
    @CrossOrigin
    @ResponseBody
    public Result getDrugDetail(@RequestBody DrugInfo drugInfo) {
        String id = drugInfo.getDrugid();
        DrugInfo drugInfo1 = drugMapper.findDrugInfoById(id);
        return Result.succeed(drugInfo1);
    }

    /**
     * 更新状态
     * @return
     */
    @RequestMapping("/upgradeStatus")
    @CrossOrigin
    @ResponseBody
    public Result upgradeStatus(@RequestBody Drug drugInfo) {
        String id = drugInfo.getDrugid();
        int status = drugInfo.getStatus();
        int res = 0;
        if (status == 0) {
            res = drugMapper.upgradeStatus(id,1);
        } else {
            res = drugMapper.upgradeStatus(id,0);
        }
        return Result.succeed(res);
    }

    /**
     * 寻找药品
     * @return
     */
    @RequestMapping("/search")
    @CrossOrigin
    @ResponseBody
    public Result searchDrug(@RequestBody SearchQuery query) {

        String title = query.getTitle();
        String type = query.getType();
        List<Drug> drugList = new ArrayList<>();
        if (type.equals("ID")) {
            drugList = drugMapper.findDrugsSearchID(title);
        }
        if (type.equals("Name")) {
            drugList = drugMapper.findDrugsSearchByName(title);
        }

        return Result.succeed(drugList);

    }


}
