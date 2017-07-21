package cn.nexuslink.model;

import java.io.Serializable;

/**description 数据库栏目表对应前端所需要的信息
 * Created by 罗浩 on 2017/3/18.
 */
public class CategoryVO implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private int pid;
    private String type;
    private String content;
    private String templateIndex;
    private String templateList;
    private String templateDetail;
    private String url;
    private String cover;
    private int docCount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplateIndex() {
        return templateIndex;
    }

    public void setTemplateIndex(String templateIndex) {
        this.templateIndex = templateIndex;
    }

    public String getTemplateList() {
        return templateList;
    }

    public void setTemplateList(String templateList) {
        this.templateList = templateList;
    }

    public String getTemplateDetail() {
        return templateDetail;
    }

    public void setTemplateDetail(String templateDetail) {
        this.templateDetail = templateDetail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }

    public static CategoryVO valueOf(CategoryDO cm){
        CategoryVO temp = new CategoryVO();
        temp.setId(cm.getId());
        temp.setPid(cm.getPid());
        temp.setTitle(cm.getTitle());
        temp.setCover(cm.getCover());
        temp.setTemplateDetail(cm.getTemplateDetail());
        temp.setTemplateList(cm.getTemplateList());
        temp.setTemplateIndex(cm.getTemplateIndex());
        temp.setDocCount(cm.getDocCount());
        temp.setUrl(cm.getUrl());
        temp.setType(cm.getType());
        temp.setContent(cm.getContent());
        return temp;
    }
}
