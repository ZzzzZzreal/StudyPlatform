package studyarea.practice.domain;

import java.util.List;

/**
 * Created by zlc on 17-7-25.
 */
public class Examination {
    private String id;
    private String belong;
    private List<Problem> questionList;
    private List<String> answerList;
    private String date;

    public Examination() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public List<Problem> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Problem> questionList) {
        this.questionList = questionList;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id='" + id + '\'' +
                ", belong='" + belong + '\'' +
                ", questionList=" + questionList +
                ", answerList=" + answerList +
                ", date='" + date + '\'' +
                '}';
    }
}
