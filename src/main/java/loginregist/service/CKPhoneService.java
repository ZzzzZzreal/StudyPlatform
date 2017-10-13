package loginregist.service;


import loginregist.dao.RegistDao;

/**
 * 此类主要为对邮箱的格式进行判断
 * 返回值为boolean类型
 * 将邮件用正则表达式进行判断
 * 完成对邮件的格式判断
 *
 */
public class CKPhoneService {
    /**
     * 首先创建一个返回值为boolean的方法
     * 然后对传来的邮箱进行格式判断
     * 如果邮箱,满足条件
     * 返回true
     * 如果返回值不满足
     * 返回false
     * @throws Exception
     * @throws ClassNotFoundException
     */
    //创建方法判断邮件是否合法
    public boolean cKphonelServise(String phone) throws ClassNotFoundException, Exception{
        //利用正则表达式判断是否合法
        boolean matches=phone.matches("1[3-8][0-9]{9}");
        //如果正则表达式正确
        if(matches){
            //返回true
            RegistDao registdao=new RegistDao();
            boolean sda=registdao.cKphone(phone);
            if(sda){
                return true;
            }else{

                return false;
            }
            //如果不是
        }else{
            //发回false
            System.out.println("手机号格式不合法");
            return false;
        }

    }
}
