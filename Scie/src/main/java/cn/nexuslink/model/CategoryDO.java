package cn.nexuslink.model;

import java.io.Serializable;

/**description 对数据库中的栏目表的对应moedel类
 * Created by 罗浩 on 2017/3/18.
 */
public class CategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String title;
    private int pid;
    private String type;
    private String modelId;
    private int sort;
    private String content;
    private String metaTitle;
    private String metaKeywords;
    private String description;
    private String templateIndex;
    private String templateList;
    private String templateDetail;
    private String url;
    private String cover;
    private int display;
    private int publish;
    private int nav;
    private int comment;
    private int checkLevel;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public int getNav() {
        return nav;
    }

    public void setNav(int nav) {
        this.nav = nav;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getCheckLevel() {
        return checkLevel;
    }

    public void setCheckLevel(int checkLevel) {
        this.checkLevel = checkLevel;
    }

    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }
}
