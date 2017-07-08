package com.dao.Impl;

import com.dao.IRecordDao;
import com.pojo.RecordDO;
import com.pojo.RecordVO;
import com.pojo.StudentDO;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ÂÞºÆ on 2017/6/6.
 */
@Repository("recordDao")
public class RecordImpl implements IRecordDao {

    private  final String saveRecord = "insert into record (sno) values (?) ";

    private final String updateSingleScoreSql1 = "update record set score = ? , flag = 1 where id = ?";

    private final String updateSingleScoreSql2 = "insert into record (sno, score, flag) values (?, ?, 1)";

    private final String listRecordSql = "select * from record ORDER BY id DESC limit ?";

    private final String listRecordVOSql = "SELECT student.*,temp1.* from student," +
            "(SELECT * FROM record ORDER BY time DESC LIMIT ? ) AS temp1 WHERE temp1.sno=student.sno";

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveListRecord(final ArrayList<StudentDO> studentDOList) {

        jdbcTemplate.batchUpdate(saveRecord, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                StudentDO stu = (StudentDO) studentDOList.get(i);
                ps.setInt(1, stu.getSno());
            }

            @Override
            public int getBatchSize() {
                return studentDOList.size();
            }
        });
    }

    @Override
    public Integer updateSingleScore(int score, int id, int sno) {

        if(0 != id)
            return jdbcTemplate.update(updateSingleScoreSql1, new Object[]{score, id});

        return jdbcTemplate.update(updateSingleScoreSql2, new Object[]{sno, score});
    }

    @Override
    public List<RecordDO> ListRecord(int limit) {

        final List<RecordDO> recordDOList = new ArrayList<>();
        jdbcTemplate.query(listRecordSql, new Object[]{limit}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                RecordDO rd = new RecordDO();
                rd.setId(rs.getInt("id"));
                rd.setSno(rs.getInt("sno"));
                rd.setScore(rs.getInt("score"));
                rd.setTime(rs.getString("time"));
                rd.setFlag(rs.getInt("flag"));

                recordDOList.add(rd);
            }
        });

        return recordDOList;
    }

    @Override
    public List<RecordVO> ListRecordVO(int limit) {
        final List<RecordVO> recordVOList = new ArrayList<>();
        jdbcTemplate.query(listRecordVOSql, new Object[]{limit}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                RecordVO rd = new RecordVO();
                rd.setId(rs.getInt("id"));
                rd.setSno(rs.getInt("sno"));
                rd.setScore(rs.getInt("score"));
                rd.setTime(rs.getString("time"));
                rd.setFlag(rs.getInt("flag"));
                rd.setTotalScore(rs.getInt("total_score"));
                rd.setTimes(rs.getInt("times"));
                rd.setName(rs.getString("name"));
                rd.setClassNumber(rs.getInt("class_number"));
                rd.setSex(rs.getString("sex"));

                recordVOList.add(rd);
            }
        });

        return recordVOList;
    }
}
