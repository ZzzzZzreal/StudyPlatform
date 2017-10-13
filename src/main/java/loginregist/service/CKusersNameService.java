package loginregist.service;

/**
 * 此类主要是对用户名的格式进行判断
 * 如果合法将返回true
 * 不合法返回false
 *在数据库前面进行判断
 */

//创建类
public class CKusersNameService {
    //创建方法对用户名的格式进行判断返回值为boolean类型
    public boolean ckUsersNameService(String userName){
        //判断如果用户名符合条件则返回true
        if(null!=userName){
            return true;
        }
        //如果不满足条件返回false
        return false;

    }


}
