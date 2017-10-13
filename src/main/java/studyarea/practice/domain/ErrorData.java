package studyarea.practice.domain;

import java.util.List;

/**
 * Created by zlc on 17-7-26.
 */
public class ErrorData {
    //错题集
    private List<ErrorProblem> list;
    //分数
    private int score;
    //评价
    private String note;

    public ErrorData() {
        super();
    }

    public ErrorData(List<ErrorProblem> list, int score, String note) {
        this.list = list;
        this.score = score;
        this.note = note;
    }

    public List<ErrorProblem> getList() {
        return list;
    }

    public void setList(List<ErrorProblem> list) {
        this.list = list;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "list=" + list +
                ", score=" + score +
                ", note='" + note + '\'' +
                '}';
    }
}
