package studyarea.interact.appointment.dao;

import domain.Data;
import studyarea.interact.appointment.domain.Course;

/**
 * Created by zlc on 17-7-24.
 */
public interface AppointDao {
    public abstract Data appointList();
    public abstract Course appointDetail(String id);
    public abstract String appointApply(String u_id,String c_id);
    public abstract String appointModify(String c_id);
    public abstract String viewCharacter(String u_id);
}
