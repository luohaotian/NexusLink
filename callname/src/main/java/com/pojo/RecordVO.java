package com.pojo;

/**
 * Created by ÂÞºÆ on 2017/6/12.
 */
public class RecordVO {

    private Integer sno;
    private String  name;
    private Integer classNumber;
    private Integer totalScore;
    private String sex;
    private  Integer times;

    private Integer id;
    private String time;
    private Integer score;
    private Integer flag;

    @Override
    public String toString() {
        return "RecordVO{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", totalScore=" + totalScore +
                ", sex='" + sex + '\'' +
                ", times=" + times +
                ", id=" + id +
                ", time='" + time + '\'' +
                ", score=" + score +
                ", flag=" + flag +
                '}';
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
