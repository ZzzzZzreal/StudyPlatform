package domain;

/**
 * Created by hp on 17-7-25.
 */
public class SigninDomain {

    private String u_id;
    private String monday="未签到";
    private String uesday="未签到";
    private String wednesday="未签到";
    private String thursday="未签到";
    private String friday="未签到";
    private String saturday="未签到";
    private String sunday="未签到";

    public SigninDomain(String s_id, String monday, String uesday, String wednesday, String thursday, String friday,String saturday, String sunday) {
        this.u_id = s_id;
        this.monday = monday;
        this.uesday = uesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday=saturday;
        this.sunday = sunday;
    }
    public SigninDomain(){
        super();
    }

    public String getS_id() {
        return u_id;
    }

    public void setS_id(String s_id) {
        this.u_id = s_id;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getUesday() {
        return uesday;
    }

    public void setUesday(String uesday) {
        this.uesday = uesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    @Override
    public String toString() {
        return "signindomain{" +
                "s_id='" + u_id + '\'' +
                ", monday='" + monday + '\'' +
                ", uesday='" + uesday + '\'' +
                ", wednesday='" + wednesday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", friday='" + friday + '\'' +
                ", sunday='" + sunday + '\'' +
                '}';
    }
}
