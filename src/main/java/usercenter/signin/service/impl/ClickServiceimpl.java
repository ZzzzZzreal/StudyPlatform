package usercenter.signin.service.impl;

import usercenter.signin.service.CilckSigninService;
import usercenter.signin.signindao.ClickSigninDao;
import usercenter.signin.signindao.CoinSigninDao;
import usercenter.signin.signindao.impl.ClickSigninDaoimpl;
import usercenter.signin.signindao.impl.CoinSigninDaoimpl;

/**这个类为CilckSigninService的实现类
 *
 * 调用方法对数据库进行操作
 * Created by hp on 17-7-25.
 */
public class ClickServiceimpl implements CilckSigninService {
    public boolean cilcksignin(String u_id) {
        //判断是否签到
        //调用方法查询的沪剧库当代天日期是否签到
        CoinSigninDao coinSignin= new CoinSigninDaoimpl();
        boolean boo=coinSignin.coinSigninDao(u_id);
        //判断是否签到
        if(boo==true){

            return false;
        }else {
            //创建对象
            ClickSigninDao clickSignin = new ClickSigninDaoimpl();
            //调用方法
            String ss = clickSignin.clicksigbindao(u_id);
            return true;
        }
    }
}
