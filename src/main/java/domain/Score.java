package domain;

/**
 * 课程成绩类
 */
public class Score {

    public static String name;
    public static String score;

    public Score(){

    }
    public Score(String name,String score){
        this.name=name;
        this.score=score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }
}
