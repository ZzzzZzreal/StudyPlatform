package studyarea.interact.questionarea.service.impl;

import studyarea.interact.questionarea.dao.imp.AnswerListDaoImpl;
import studyarea.interact.questionarea.dao.imp.ListDaoImpl;
import studyarea.interact.questionarea.service.AnswerListService;

import java.util.ArrayList;

/**
 * Created by jaques on 17-7-26.
 */
public class AnswerListServiceImpl implements AnswerListService {
    public ArrayList check(String a_id) {
        AnswerListDaoImpl answerListDaoImpl=new AnswerListDaoImpl();
        ArrayList arrayList=answerListDaoImpl.check(a_id);
        return arrayList;
    }
}
