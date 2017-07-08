package com.dao;

import com.pojo.RecordDO;
import com.pojo.RecordVO;
import com.pojo.StudentDO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
public interface IRecordDao {

    public void saveListRecord(ArrayList<StudentDO> StudentDO);

    public Integer updateSingleScore(int score, int id, int sno);

    public List<RecordDO>ListRecord(int limit);

    public List<RecordVO>ListRecordVO(int limit);


}
