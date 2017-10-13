package domain;

/**
 * notice--公告通知的javabean，它包含的内容有
 * 1.公告id
 * 2.公告标题
 * 3.公告内容
 * 4.发布时间
 * 5.发布者id
 */
public class Notice {

    //公告id
    private String n_id;
    //公告标题
    private String n_title;
    //公告内容
    private String n_content;
    //发布时间
    private String n_time;
    //发布者id
    private String n_a_id;
    //发布者姓名
    private String n_author;

    //无参构造
    public Notice() {
        super();
    }

    public Notice(String n_id, String n_title, String n_content, String n_time, String n_a_id,String n_author) {
        this.n_id = n_id;
        this.n_title = n_title;
        this.n_content = n_content;
        this.n_time = n_time;
        this.n_a_id = n_a_id;
        this.n_author = n_author;
    }

    //SelectNoticeServlet中需要的构造
    public Notice(String n_id, String n_a_id) {
        this.n_id = n_id;
        this.n_a_id = n_a_id;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public String getN_time() {
        return n_time;
    }

    public void setN_time(String n_time) {
        this.n_time = n_time;
    }

    public String getN_a_id() { return n_a_id;
    }

    public void setN_a_id(String n_a_id) { this.n_a_id = n_a_id;
    }

    public String getN_author() {
        return n_author;
    }

    public void setN_author(String n_author) {
        this.n_author = n_author;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "n_id='" + n_id + '\'' +
                ", n_title='" + n_title + '\'' +
                ", n_content='" + n_content + '\'' +
                ", n_time='" + n_time + '\'' +
                ", n_a_id='" + n_a_id + '\'' +
                ", n_author='" + n_author + '\'' +
                '}';
    }
}

