package com.dao.Impl;

import com.dao.IStudentDao;
import com.pojo.StudentDO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
@Repository("studentDao")
public class StudentImpl implements IStudentDao {

    private final String addScoreSql = "update student set " +
            "total_score = total_score + ?  , times = times + 1 where sno = ?";

    private final String addTimeSql = "update student set times = times + 1 where sno = ?";

    private final String listStudentSql = "select * from student where class_number = ?";

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer addScore(int sno, int score) {
        return jdbcTemplate.update(addScoreSql, new Object[]{score, sno});
    }

    @Override
    public Integer addTime(int sno) {
        return jdbcTemplate.queryForObject(addTimeSql, new Object[]{sno}, Integer.class);
    }

    @Override
    public List<StudentDO> ListStudentOfClass(int classNumber) {
        final List<StudentDO> studentDOList = new ArrayList<>();

        //System.out.println(classNumber);

        jdbcTemplate.query(listStudentSql, new Object[]{classNumber}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                StudentDO stu = new StudentDO();
                stu.setSno(rs.getInt("sno"));
                stu.setName(rs.getString("name"));
                stu.setClassNumber(rs.getString("class_number"));
                stu.setSex(rs.getString("sex"));
                stu.setTimes(rs.getInt("times"));
                stu.setTotalScore(rs.getInt("total_score"));
                studentDOList.add(stu);
                System.out.println(stu.toString());
            }
        });

        //System.out.println(studentDOList.toString());

        return studentDOList;
    }
}
