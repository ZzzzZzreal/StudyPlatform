package domain;

import java.util.List;

/**
 * Data javabean，用来存放集合并返回给客户端。它包含的内容有：
 * 1、状态值
 * 2、集合
 * 3、注释
 */
public class Data {

    //状态值
    private  String status;
    //集合
    private List list;
    //注释
    private String note;

    public Data() {
    }

    public Data(String status, List list, String note) {
        this.status = status;
        this.list = list;
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Data{" +
                "status='" + status + '\'' +
                ", list=" + list +
                ", note='" + note + '\'' +
                '}';
    }
}
