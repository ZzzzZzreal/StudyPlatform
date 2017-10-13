package studyarea.practice.exam.service;

import studyarea.practice.domain.ErrorData;
import studyarea.practice.domain.ExamData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zlc on 17-7-26.
 */
public interface ExamService {
    public abstract ExamData goExam(HttpServletRequest request, String belong);
    public abstract ErrorData afterExam(HttpServletRequest request, List<String> list);
}
