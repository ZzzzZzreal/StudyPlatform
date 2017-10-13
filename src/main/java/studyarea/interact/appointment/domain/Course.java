package studyarea.interact.appointment.domain;

/**
 * Created by zlc on 17-7-25.
 * 这个类是课程的JavaBean
 */
public class Course {
    //课程id
    private String c_id;
    //课程名称
    private String c_name;
    //教师id
    private String u_id;
    //教师姓名
    private String u_name;
    //课程类型
    private String c_type;
    //课程所需积分
    private String integral;
    //提交时间
    private String issuetime;
    //课程开始日期
    private String start;
    //课程结束日期
    private String end;
    //课程开始时间
    private String begin;
    //课程结束时间
    private String terminal;
    //课程简介
    private String introduce;

    public Course() {
        super();
    }

    public Course(String c_id, String c_name, String u_id, String u_name, String c_type, String integral, String issuetime, String start, String end, String begin, String terminal, String introduce) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.u_id = u_id;
        this.u_name = u_name;
        this.c_type = c_type;
        this.integral = integral;
        this.issuetime = issuetime;
        this.start = start;
        this.end = end;
        this.begin = begin;
        this.terminal = terminal;
        this.introduce = introduce;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getIssuetime() {
        return issuetime;
    }

    public void setIssuetime(String issuetime) {
        this.issuetime = issuetime;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", u_id='" + u_id + '\'' +
                ", u_name='" + u_name + '\'' +
                ", c_type='" + c_type + '\'' +
                ", integral='" + integral + '\'' +
                ", issuetime='" + issuetime + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", begin='" + begin + '\'' +
                ", terminal='" + terminal + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
