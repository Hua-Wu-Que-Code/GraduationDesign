package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.Drug;

import java.util.ArrayList;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 返回带有total的类
 * @date 2023/5/17 02:56:41
 */
public class ListVo {
    private int total;
    private ArrayList<Drug> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Drug> getList() {
        return list;
    }

    public void setList(ArrayList<Drug> list) {
        this.list = list;
    }

    public ListVo(int total, ArrayList<Drug> list) {
        this.total = total;
        this.list = list;
    }
}
