package cn.nexuslink.pojo;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.Serializable;

/**
 * Created by 罗浩 on 2017/3/29.
 */
public class User implements Serializable {


    private String id;

    private java.lang.String name;


    public User(){

    }

    public User(String id, java.lang.String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
}
