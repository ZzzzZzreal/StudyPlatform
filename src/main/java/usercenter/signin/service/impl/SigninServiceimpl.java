package usercenter.signin.service.impl;

import domain.SigninDomain;
import usercenter.signin.service.SigninService;
import usercenter.signin.signindao.SigninDao;
import usercenter.signin.signindao.impl.SigninDaoimpl;

/**
 * 签到的实现类
 * Created by hp on 17-7-24.
 */
public class SigninServiceimpl implements SigninService {
    /**
     * 根据id查询签到情况
     *
     * @param
     * @return
     */
    public SigninDomain signinu_id(String u_id) {
        //调用方法 从数据库中查询这一周的签到情况
        //创建连接
        //判断数据库内是否有该用户


        SigninDao signindao= new SigninDaoimpl();
        //根据用户id对数据库进行操作
        SigninDomain looksigindao=signindao.findSigninu_id(u_id);




        return looksigindao;
    }
}
