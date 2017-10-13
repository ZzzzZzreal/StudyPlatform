package studyarea.practice.domain;

import java.util.List;

/**
 * Created by zlc on 17-7-26.
 */
public class ExamData {
    private String status;
    private List<Problem> list;
    private String note;

    public ExamData() {
        super();
    }

    public ExamData(String status, List<Problem> list, String note) {
        this.status = status;
        this.list = list;
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Problem> getList() {
        return list;
    }

    public void setList(List<Problem> list) {
        this.list = list;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ExamData{" +
                "status='" + status + '\'' +
                ", list=" + list +
                ", note='" + note + '\'' +
                '}';
    }
}
