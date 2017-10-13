package studyarea.interact.appointment.service;

import domain.Data;
import studyarea.interact.appointment.domain.Course;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zlc on 17-7-24.
 * 这个接口是预约课程中的业务处理的接口
 */
public interface AppointService {
    public abstract Data goAppoint();
    public abstract Course goDetail(String id);
    public abstract String goApply(HttpServletRequest request,String c_id);
}
