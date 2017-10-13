package studyarea.practice.exam.dao;

import studyarea.practice.domain.Examination;

/**
 * Created by zlc on 17-7-25.
 */
public interface ExamDao {
    public abstract Examination examApply(String belong);
    public abstract boolean examResult(String s_id,String u_id,String belong,int score,String date);
}
