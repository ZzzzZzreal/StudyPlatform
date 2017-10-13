package studyarea.practice.domain;

/**
 * Created by zlc on 17-7-25.
 */
public class Problem {
    //题目的题号
    private int pid;
    //题目中的问题
    private String question;
    //选项A
    private String ansA;
    //选项B
    private String ansB;
    //选项C
    private String ansC;
    //选项D
    private String ansD;

    public Problem() {
        super();
    }

    public Problem(int pid, String question, String ansA, String ansB, String ansC, String ansD) {
        super();
        this.pid = pid;
        this.question = question;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "pid='"+pid+'\''+
                "question='" + question + '\'' +
                ", ansA='" + ansA + '\'' +
                ", ansB='" + ansB + '\'' +
                ", ansC='" + ansC + '\'' +
                ", ansD='" + ansD + '\'' +
                '}';
    }
}
