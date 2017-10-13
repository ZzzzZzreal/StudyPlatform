package usercenter.userInfo.service.impl;

import domain.User;
import usercenter.userInfo.dao.UserInfoDao;
import usercenter.userInfo.dao.impl.UserInfoDaoImpl;
import usercenter.userInfo.service.UserInfoService;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public class UserInfoServiceImpl implements UserInfoService {

    public ArrayList<User> findAllUser(String u_id){

        UserInfoDao userInfoDao=new UserInfoDaoImpl();

        ArrayList arrayList=new ArrayList();
       arrayList= userInfoDao.findAllUser(u_id);

       return arrayList;
    }

    public Boolean updateUser(User user){
        UserInfoDao userInfoDao=new UserInfoDaoImpl();
      Boolean fale=  userInfoDao.updateUser(user);

        return fale;
    }

    public Boolean updateImg(String img,String uid){
        UserInfoDao userInfoDao=new UserInfoDaoImpl();
        Boolean fale=userInfoDao.updateImg(img,uid);
        return fale;
    }

}
