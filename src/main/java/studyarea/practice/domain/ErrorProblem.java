package studyarea.practice.domain;

/**
 * Created by zlc on 17-7-26.
 */
public class ErrorProblem {
    private int eid;
    private String reply;
    private String answer;

    public ErrorProblem() {
        super();
    }

    public ErrorProblem(int eid, String reply, String answer) {
        this.eid = eid;
        this.reply = reply;
        this.answer = answer;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ErrorProblem{" +
                "eid=" + eid +
                ", reply='" + reply + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
