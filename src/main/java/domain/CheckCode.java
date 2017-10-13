package domain;

/**
 * Created by ch on 17-7-25.
 */
public class CheckCode {
    //成员变量
    private String code;
    //无参构造
    public CheckCode() {
    }
    //有参构造
    public CheckCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{\"CheckCode"+"\":"+ "\""+getCode()+"\"}";
    }
}