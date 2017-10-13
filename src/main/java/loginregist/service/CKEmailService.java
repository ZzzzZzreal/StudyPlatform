package loginregist.service;

/**
 * 此类主要为对邮箱的格式进行判断
 * 返回值为boolean类型
 * 将邮件用正则表达式进行判断
 * 完成对邮件的格式判断
 *
 */
public class CKEmailService {
    /**
     * 首先创建一个返回值为boolean的方法
     * 然后对传来的邮箱进行格式判断
     * 如果邮箱,满足条件
     * 返回true
     * 如果返回值不满足
     * 返回false
     */
    //创建方法判断邮件是否合法
    public boolean cKemailServise(String email){
        //利用正则表达式判断是否合法
        boolean matches=email.matches("[1-9][0-9]{5,10}@qq\\.com");

        //如果正则表达式正确
        if(matches){
            //返回true
            return true;
            //如果不是
        }else{
            //发回false

            return false;
        }
    }
}
