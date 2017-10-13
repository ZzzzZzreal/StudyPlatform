package domain;

/**
 * Created by yrq on 17-7-26.
 * 评论
 */


public class Evalute {
    private String eId;
    private String cId;//课程号
    private String evalute;//评论内容
    private String datetime;//时间

    public Evalute() {
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getEvalute() {
        return evalute;
    }

    public void setEvalute(String evalute) {
        this.evalute = evalute;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }




    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }
}
