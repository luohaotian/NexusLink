package com.service;

import com.dao.IRecordDao;
import com.dao.IStudentDao;
import com.pojo.RecordDO;
import com.pojo.RecordVO;
import com.pojo.StudentDO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
@Service("showDataService")
@Transactional
public class ShowDataService {

    @Resource
    @Qualifier("recordDao")
    private IRecordDao recordDao;

    @Resource
    @Qualifier("studentDao")
    private IStudentDao studentDao;

    public List<StudentDO> listStudentOfClass(int classNumber) {

        return studentDao.ListStudentOfClass(classNumber);
    }

    public List<RecordDO> listRandomStudent(int classNumber, int limit) {

        List<StudentDO> studentDOList = studentDao.ListStudentOfClass(classNumber);

        int i = 0;
        int studentNumberOfClass = studentDOList.size();
        if (studentNumberOfClass < limit ) {
            return null;
        }
        StudentDO[] students = new StudentDO[studentNumberOfClass];
        studentDOList.toArray(students);
        System.out.println(students);
        HashSet hashSet = new HashSet(limit);

        Random r = new Random();
        while (i < limit) {
            int t = r.nextInt(studentNumberOfClass);
            System.out.println(studentNumberOfClass);
            System.out.println(t);
            System.out.println(students[t]);
            boolean flag = hashSet.add(students[t]);
            if (flag)
                i++;
        }
        recordDao.saveListRecord(new ArrayList(hashSet));

        List<RecordDO> recordDOList = recordDao.ListRecord(limit);

        return recordDOList;
    }

    public List<RecordDO> listRealTimeRecord(int limit) {

        return recordDao.ListRecord(limit);
    }

    public List<RecordVO> listRealTimeRecordVO(int limit) {

        return recordDao.ListRecordVO(limit);
    }

}
