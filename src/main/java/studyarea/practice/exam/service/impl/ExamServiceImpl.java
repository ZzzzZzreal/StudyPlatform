package studyarea.practice.exam.service.impl;

import domain.User;
import studyarea.practice.domain.ErrorData;
import studyarea.practice.domain.ErrorProblem;
import studyarea.practice.domain.ExamData;
import studyarea.practice.domain.Examination;
import studyarea.practice.exam.dao.ExamDao;
import studyarea.practice.exam.dao.impl.ExamDaoImpl;
import studyarea.practice.exam.service.ExamService;
import utils.CreateID;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zlc on 17-7-26.
 */
public class ExamServiceImpl implements ExamService {
    /**
     * 请求测试时的业务处理
     * 判断是否登录，登录才能获取试题
     * 将试题存入JavaBean，返回客户端
     *
     * @param request
     * @param belong
     * @return
     */
    public ExamData goExam(HttpServletRequest request, String belong) {
        ExamDao examDao = new ExamDaoImpl();
        String u_id = null;
        try {
            User user = (User) request.getSession().getAttribute("user");
            u_id = user.getU_id();
        } catch (Exception e) {
            e.printStackTrace();
            ExamData examData = new ExamData("0", null, "请先登录");
            return examData;
        }
        if (u_id == null) {
            ExamData examData = new ExamData("0", null, "请先登录");
            return examData;
        }
        //查询数据库，得到完整试题
        Examination examination = examDao.examApply(belong);
        //将数据存入JavaBean
        String status = "1";
        String note = "加油吧，骚年！";
        ExamData examData = new ExamData();
        examData.setStatus(status);
        examData.setList(examination.getQuestionList());
        examData.setNote(note);
        //将答案写入session
        request.getSession().setAttribute("answer", examination);
        //返回试题的JavaBean
        return examData;
    }

    public ErrorData afterExam(HttpServletRequest request, List<String> list) {
        //从session中获取存入的答案，String类型的集合
        Examination examination= (Examination) request.getSession().getAttribute("answer");
        List<String> answer = examination.getAnswerList();
                //创建一个错误题目题号的集合
        ErrorProblem error=new ErrorProblem();
        List<ErrorProblem> errorList=new ArrayList<ErrorProblem>();
        //遍历回答，将错题存入错题集
        ListIterator listIterator=list.listIterator();
        //计算错题数目
        int number=0;
        while (listIterator.hasNext()){
            int index=listIterator.nextIndex();
            System.out.println("遍历回答时的索引："+index);
            String correctAnswer=answer.get(index);
            String reply= (String) listIterator.next();
            if (!correctAnswer.equals(reply)){
                number+=1;
                error.setEid(index);
                error.setReply(reply);
                error.setAnswer(correctAnswer);
                errorList.add(error);
            }
        }
        int score=(5-number)*20;
        String note=null;
        if (score<60){
            note="您还没有出山的资格，请继续努力";
        }else if (score>=60&&score<80){
            note="您初入江湖，已崭露头角";
        }else if (score>=80&&score<100){
            note="您已经是一流高手，可以独当一面了";
        }else if (score==100){
            note="您的功力已经登峰造极了，必将一鸣惊人";
        }else {
            note="?????";
        }
        //存入错题集
        ErrorData errorData=new ErrorData();
        errorData.setList(errorList);
        errorData.setScore(score);
        errorData.setNote(note);
        //将成绩存入数据库
        ExamDao examDao=new ExamDaoImpl();
        CreateID createID=new CreateID();
        String s_id=createID.createID();
        String u_id=((User)request.getSession().getAttribute("user")).getU_id();
        String date=examination.getDate();
        String belong=examination.getBelong();
        boolean result=true;
        do {
            result = examDao.examResult(s_id, u_id,belong, score, date);
        }while (!result);
        return errorData;
    }
}
