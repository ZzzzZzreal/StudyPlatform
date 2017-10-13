package studyarea.interact.questionarea.service.impl;

import domain.Question;
import studyarea.interact.questionarea.dao.imp.QuestionAreaDaoImpl;
import studyarea.interact.questionarea.service.QuestionAreaService;

/**
 * 问答区service的实现类
 * Created by root on 17-7-24.
 */
public class QuestionAreaServiceImpl implements QuestionAreaService {
    //成员方法  将javabean的成员变量存入数据库
    public boolean addQuestion(Question question) {
        QuestionAreaDaoImpl questionAreaDaoImp=new QuestionAreaDaoImpl();
        boolean boo=questionAreaDaoImp.addQuestion(question);
        if(boo){
            return true;
        }else{
            return false;
        }
    }
}
