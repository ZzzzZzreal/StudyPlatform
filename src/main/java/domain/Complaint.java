package domain;

/**
 * Complaint ---意见反馈的javabean。它包含的内容有：
 * 1、意见id
 * 2、意见内容
 * 3、提交者id
 * 4、提交时间
 * 5、回复状态
 */
public class Complaint {

    //意见id
    private String cp_id;
    //意见内容
    private String cp_content;
    //提交者id
    private String cp_a_id;
    //提交时间
    private String cp_time;
    //回复状态
    private String cp_status;

    public Complaint() {
    }

    public Complaint(String cp_id, String cp_content, String cp_a_id, String cp_time, String cp_status) {
        this.cp_id = cp_id;
        this.cp_content = cp_content;
        this.cp_a_id = cp_a_id;
        this.cp_time = cp_time;
        this.cp_status = cp_status;
    }

    public String getCp_id() {
        return cp_id;
    }

    public void setCp_id(String cp_id) {
        this.cp_id = cp_id;
    }

    public String getCp_content() {
        return cp_content;
    }

    public void setCp_content(String cp_content) {
        this.cp_content = cp_content;
    }

    public String getCp_a_id() {
        return cp_a_id;
    }

    public void setCp_a_id(String cp_a_id) {
        this.cp_a_id = cp_a_id;
    }

    public String getCp_time() {
        return cp_time;
    }

    public void setCp_time(String cp_time) {
        this.cp_time = cp_time;
    }

    public String getCp_status() {
        return cp_status;
    }

    public void setCp_status(String cp_status) {
        this.cp_status = cp_status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "cp_id='" + cp_id + '\'' +
                ", cp_content='" + cp_content + '\'' +
                ", cp_a_id='" + cp_a_id + '\'' +
                ", cp_time='" + cp_time + '\'' +
                ", cp_status='" + cp_status + '\'' +
                '}';
    }
}
