package com.pojo;

/**
 * Created by ÂÞºÆ on 2017/6/5.
 */
public class StudentDO {
    private Integer sno;
    private String  name;
    private String classNumber;
    private Integer totalScore;
    private String sex;
    private  Integer times;

    @Override
    public String toString() {
        return "StudentDO{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", totalScore=" + totalScore +
                ", sex='" + sex + '\'' +
                ", times=" + times +
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

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
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
}
