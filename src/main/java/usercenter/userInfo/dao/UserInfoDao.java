package usercenter.userInfo.dao;

import domain.User;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public interface UserInfoDao {
    //查询登录的用户信息
     ArrayList findAllUser(String u_id);
    //更新用户信息
     Boolean updateUser(User user);
    //更新头像
    Boolean updateImg(String img, String uid);

}
