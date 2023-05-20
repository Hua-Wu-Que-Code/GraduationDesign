package com.example.springboot.mapper;

import com.example.springboot.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 体检详情mapper
 * @date 2023/5/19 13:43:51
 */
@Mapper
public interface ExamMapper {
    @Select(" select * from exam where id =#{id}")
    Exam findExamById(int limit);


    int insert(Exam exam);

    @Select(" select id from exam where date =#{date} and userid =#{userid} and doctorid = #{doctorid}")
    int findExamIdByDate(Date date, String userid, String doctorid);
}
