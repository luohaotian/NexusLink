package com.dao;

import com.pojo.StudentDO;

import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
public interface IStudentDao {

    public Integer addScore(int sno, int score);

    public Integer addTime(int sno);

    public List<StudentDO> ListStudentOfClass(int classNumber);

}
