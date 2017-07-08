package com.pojo;

/**
 * Created by ÂÞºÆ on 2017/6/5.
 */
public class RecordDO {

    private Integer id;
    private Integer sno;
    private String time;
    private Integer score;
    private Integer flag;

    @Override
    public String toString() {
        return "RecordDO{" +
                "id=" + id +
                ", sno=" + sno +
                ", time='" + time + '\'' +
                ", score=" + score +
                ", flag=" + flag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
