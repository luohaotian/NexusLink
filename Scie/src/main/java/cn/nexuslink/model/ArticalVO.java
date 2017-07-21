package cn.nexuslink.model;

import java.util.Date;

/**description 将数据库artical表的信息转化为前端实际需要的信息
 * Created by 罗浩 on 2017/3/18.
 */
public class ArticalVO {
    private int id;
    private int voteId;
    private String title;
    private String content;
    private String cover;
    private int viewCount;
    private int commentCount;
    private Date publishDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getComment_count() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public static ArticalVO valueOf(ArticalDO am){
        ArticalVO tem = new ArticalVO();
        tem.setId(am.getId());
        tem.setVoteId(am.getVoteId());
        tem.setContent(am.getContent());
        tem.setTitle(am.getTitle());
        tem.setViewCount(am.getViewCount());
        tem.setCover(am.getCover());
        tem.setPublishDate(am.getPublishDate());
        tem.setCommentCount(am.getCommentCount());
        return tem;
    }


}
