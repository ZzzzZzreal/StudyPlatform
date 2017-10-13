package studyarea.interact.appointment.service.impl;

import domain.Data;
import domain.User;
import studyarea.interact.appointment.dao.AppointDao;
import studyarea.interact.appointment.dao.impl.AppointDaoImpl;
import studyarea.interact.appointment.domain.Course;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zlc on 17-7-24.
 */
public class AppointServiceImpl implements studyarea.interact.appointment.service.AppointService {
    public Data goAppoint(){
        AppointDao appointDao=new AppointDaoImpl();
        Data data=appointDao.appointList();
        return data;
    }

    public Course goDetail(String id) {
        AppointDao appointDao=new AppointDaoImpl();
        Course course=appointDao.appointDetail(id);
        return course;
    }

    public String goApply(HttpServletRequest request,String c_id) {
        //u_id有session获取，为空返回提示登录，不为空则添加入课程表
        //String u_id=String.valueOf(1);
        User user= null;
        String u_id= null;
        try {
            user = (User)request.getSession().getAttribute("user");
            u_id = user.getU_id();
        } catch (Exception e) {
            e.printStackTrace();
            return "请先登录";
        }
        if (u_id == null) {
            return "请先登录";
        }
        //查询该用户权限
        AppointDao appointDao=new AppointDaoImpl();
        //String character=appointDao.viewCharacter(u_id);
        String character=user.getIdentify();
        if (!character.equals("学员")){
            return "您无此权限";
        }
        String result=appointDao.appointApply(u_id,c_id);
        if (!result.equals("预约成功")){
            return result;
        }
        String modify=appointDao.appointModify(c_id);
        if (!modify.equals("修改成功")){
            return "预约失败";
        }
        return result;
    }

}
