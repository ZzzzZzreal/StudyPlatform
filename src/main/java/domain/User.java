package domain;

/**
 * Created by ch on 17-7-24.
 * 创建一个用户javabean
 *
 */
public class User {
    private String u_id;
    //用户名 为其讹误认为
    private String u_name;
    //用户身份
    private String identify;
    //用户电话
    private String phone;
    //用户邮箱
    private String email;
    //用户密码
    private String pwd;
    //状态码
    private String status;
    //用户性别
    private String gender;
    //用户头像
    private String photo;

    public User() {
    }

    public User(String u_name, String identify, String phone, String email, String pwd, String status, String gender, String photo) {
        this.u_name = u_name;
        this.identify = identify;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.status = status;
        this.gender = gender;
        this.photo = photo;
    }

    public User(String u_id, String u_name, String identify, String phone,String status, String gender,String photo){
        this.u_id = u_id;
        this.u_name = u_name;
        this.identify = identify;
        this.phone = phone;
        this.status = status;
        this.gender = gender;
        this.photo=photo;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_name='" + u_name + '\'' +
                ", identify='" + identify + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status='" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}