package cn.nexuslink.model;

/**对栏目表精简，在进行栏目信息传输的时候信息更简洁
 * Created by 罗浩 on 2017/3/19.
 */
public class EasyCategoryVO {

    private int id;
    private String title;
    private int pid;

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
}
