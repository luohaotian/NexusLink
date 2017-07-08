package com.service;

import com.dao.IRecordDao;
import com.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ÂŞºÆ on 2017/6/6.
 */
@Service("operateDataService")
//@Transactional
public class OperateDataService {

    @Resource
    @Qualifier("studentDao")
    private IStudentDao studentDao;

    @Resource
    @Qualifier("recordDao")
    private IRecordDao recordDao;

    public boolean addScore(int id, int sno, int score) {
        int a = recordDao.updateSingleScore(score, id, sno);
        int b =  studentDao.addScore(sno, score);
        System.out.println(a +":" + b);
        if (a > 0 && b > 0)
            return true;
        return false;
    }
}
