package domain;

/**
 * 此类作为问答区的javabean
 * 将问题的信息存入这里
 * Created by jaques on 17-7-24.
 */
public class Question {
    //成员变量
    private String q_id;
    private String u_id;
    private String time;
    private String title;
    private String detail;
    private String picture;
    private String score;
    private String a_id;
    //无参构造
    public Question() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //有参构造
    public Question(String u_id, String time,String title, String detail, String picture, String score, String a_id) {
        this.u_id = u_id;
        this.time=time;
        this.title = title;
        this.detail = detail;
        this.picture = picture;
        this.score = score;
        this.a_id = a_id;
    }

    public Question(String q_id, String u_id, String time, String title, String detail, String picture, String score, String a_id) {
        this.q_id = q_id;
        this.u_id = u_id;
        this.time = time;
        this.title = title;
        this.detail = detail;
        this.picture = picture;
        this.score = score;
        this.a_id = a_id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "u_id='" + u_id + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", picture='" + picture + '\'' +
                ", score='" + score + '\'' +
                ", a_id='" + a_id + '\'' +
                '}';
    }

}
