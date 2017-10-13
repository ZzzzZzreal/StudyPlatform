package loginregist.service;

import loginregist.dao.RegistDao;

/**
 * Created by ch on 17-7-26.
 */
public class CKservice {
    public String CkAll(String username,String pwd,String pwd1,String phone,String email,String checkcode,String randCheckCode) throws Exception {
        RegistDao registDao=new RegistDao();
        String note=null;

        if (!(registDao.cKemail(email)||email.matches("[1-9][0-9]{5,10}@qq\\.com"))){
            System.out.println(email);
            note= "邮箱输入有误!";
        }else {
            if (!registDao.cKuserName(username)||username.length()>=6) {
                note= "用户名输入有误!";

            } else {
                if (!registDao.cKphone(phone))
                {
                    note= "手机号输入有误!";
                }
                else{
                    if (pwd==null||pwd.length()<=6){
                        note= "密码输入有误!";
                    }else {
                        if (pwd.equals(pwd1)==false){
                            System.out.println(pwd+pwd1);
                            note= "俩次密码输入不一致!";
                        }else {
                            if (checkcode==null||(checkcode.equals(randCheckCode)==false)){
                                note= "验证码输入错误!";
                            }else {
                                note="正确";
                            }
                        }
                    }
                }
            }
        }
     return note;
    }
}
