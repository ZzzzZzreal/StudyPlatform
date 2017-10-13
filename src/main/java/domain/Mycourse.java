package domain;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by yrq on 17-7-26.
 */
public class Mycourse {

    private String cId;
    private Date start; //开始日期
    private Date end;   //结束日期
    private Time begin;  //开始时间
    private Time terminal; //结束时间
    private String introduce;//介绍

    private String cName;
    private String cType;
    private String teacher;

    public Mycourse() {
    }

    @Override
    public String toString() {
        return "Mycourse{" +
                "cId='" + cId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", begin=" + begin +
                ", terminal=" + terminal +
                ", introduce='" + introduce + '\'' +
                ", cName='" + cName + '\'' +
                ", cType='" + cType + '\'' +
                '}';
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Time getBegin() {
        return begin;
    }

    public void setBegin(Time begin) {
        this.begin = begin;
    }

    public Time getTerminal() {
        return terminal;
    }

    public void setTerminal(Time terminal) {
        this.terminal = terminal;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }




    public Mycourse(String cId, String cName, String cType, Date start, Date end, Time begin, Time terminal, String introduce) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
        this.start = start;
        this.end = end;
        this.begin = begin;
        this.terminal = terminal;
        this.introduce = introduce;
    }


    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
