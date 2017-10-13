package usercenter.mycourse.service.impl;

import domain.User;
import usercenter.mycourse.dao.MycourseDao;
import usercenter.mycourse.dao.impl.MycourseDaoImpl;
import usercenter.mycourse.service.MycourseService;
import usercenter.userInfo.dao.UserInfoDao;
import usercenter.userInfo.dao.impl.UserInfoDaoImpl;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public class MycourseServiceImpl implements MycourseService {

    public ArrayList<User> findMycourse(String u_id){

        MycourseDao mycourseDao=new MycourseDaoImpl();

        ArrayList arrayList=new ArrayList();
       arrayList= mycourseDao.findMycourse(u_id);

       return arrayList;
    }



}
