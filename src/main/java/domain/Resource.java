package domain;

/**
 * 此类为学习资源详情的javabean
 * Created by huangwei on 17-7-24.
 */
public class Resource {
    //资源名字
    private String r_name;
    //资源上传时间
    private String r_uptime;
    //资源描述
    private String desp;
    // 资源时长
    private String duration;
    //资源大小
    private String filesize;
    //课程方向
    private String major;
    //课程类型
    private String genre;
    //资源id
    private String r_id;
    //资源价格
    private String r_price;
    //文件类型
    private String r_type;
    //链接
    private String r_URL;

    //无参构造
    public Resource(){

    }

    public Resource(String r_name, String r_uptime, String desp, String duration, String filesize, String major, String genre, String r_id, String r_price, String r_type, String r_URL) {
        this.r_name = r_name;
        this.r_uptime = r_uptime;
        this.desp = desp;
        this.duration = duration;
        this.filesize = filesize;
        this.major = major;
        this.genre = genre;
        this.r_id = r_id;
        this.r_price = r_price;
        this.r_type = r_type;
        this.r_URL = r_URL;
    }

    //set/get方法
    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_uptime() {
        return r_uptime;
    }

    public void setR_uptime(String r_uptime) {
        this.r_uptime = r_uptime;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_price() {
        return r_price;
    }

    public void setR_price(String r_price) {
        this.r_price = r_price;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getR_URL() {
        return r_URL;
    }

    public void setR_URL(String r_URL) {
        this.r_URL = r_URL;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "r_name='" + r_name + '\'' +
                ", r_uptime='" + r_uptime + '\'' +
                ", desp='" + desp + '\'' +
                ", duration='" + duration + '\'' +
                ", filesize='" + filesize + '\'' +
                ", major='" + major + '\'' +
                ", genre='" + genre + '\'' +
                ", r_id='" + r_id + '\'' +
                ", r_price='" + r_price + '\'' +
                ", r_type='" + r_type + '\'' +
                ", r_URL='" + r_URL + '\'' +
                '}';
    }
}


