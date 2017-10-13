package usercenter.mycourse.dao;

import domain.User;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public interface MycourseDao {
    //查询登录的用户信息
     ArrayList findMycourse(String u_id);


}
