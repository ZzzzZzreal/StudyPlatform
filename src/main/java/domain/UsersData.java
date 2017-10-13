package domain;

/**
 *
 * 创建JavaBean
 * 目的返回json格式
 *
 */
public class UsersData {


    /**
     *主要为激活状态
     *字符串
     *注释的返回
     *为接口文档进行准备
     */

    private String Status;
    private String Data;
    private String Note;
    public UsersData() {
    }
    public UsersData(String status, String data, String note) {
        super();
        Status = status;
        Data = data;
        Note = note;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getData() {
        return Data;
    }
    public void setData(String data) {
        Data = data;
    }
    public String getNote() {
        return Note;
    }
    public void setNote(String note) {
        Note = note;
    }
    @Override
    public String toString() {
        return "UsersData [Status=" + Status + ", Data=" + Data + ", Note=" + Note + "]";
    }







}
