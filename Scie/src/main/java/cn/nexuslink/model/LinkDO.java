package cn.nexuslink.model;

import java.io.Serializable;

/**
 * Created by 罗浩 on 2017/3/18.
 */
public class LinkDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String linkName;
    private String url;
    private int sort;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
