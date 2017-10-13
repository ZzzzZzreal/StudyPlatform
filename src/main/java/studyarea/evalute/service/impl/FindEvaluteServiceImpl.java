package studyarea.evalute.service.impl;

import studyarea.evalute.dao.FindEvaluteDao;
import studyarea.evalute.dao.impl.FindEvaluteDaoImpl;
import studyarea.evalute.service.FindEvaluteService;

import java.util.ArrayList;

/**
 * Created by yrq on 17-7-26.
 */
public class FindEvaluteServiceImpl implements FindEvaluteService {
    public ArrayList evalute(String c_id){

        FindEvaluteDao evaluteDao=new FindEvaluteDaoImpl();
        ArrayList fale=   evaluteDao.evalute(c_id);
        return fale;
    }

}
