package domain;

/**
 * Created by hp on 17-7-25.
 */
public class ListDomain {
    private String r_id;
    private  String r_name;
    private String r_uptime;
    private String duration;
    private String filesize;

    public ListDomain(String r_id, String r_name, String r_uptime, String duration,String filesize) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_uptime = r_uptime;
        this.duration = duration;
        this.filesize=filesize;

    }

    public ListDomain() {
        super();
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

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

    @Override
    public String toString() {
        return "ListDomain{" +
                "r_id='" + r_id + '\'' +
                ", r_name='" + r_name + '\'' +
                ", r_uptime='" + r_uptime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
