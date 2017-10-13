package usercenter.userInfo.service;

import domain.User;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public interface UserInfoService {

      ArrayList findAllUser(String id);
      Boolean updateUser(User user);
      Boolean updateImg(String img, String uid);
}
