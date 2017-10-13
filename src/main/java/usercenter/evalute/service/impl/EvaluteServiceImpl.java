package usercenter.evalute.service.impl;

import usercenter.evalute.dao.EvaluteDao;
import usercenter.evalute.dao.impl.EvaluteDaoImpl;
import usercenter.evalute.service.EvaluteService;

/**
 * Created by yrq on 17-7-26.
 */
public class EvaluteServiceImpl implements EvaluteService {
    public Boolean evalute(String c_id,String evalute){

        EvaluteDao evaluteDao=new EvaluteDaoImpl();
     Boolean fale=   evaluteDao.evalute(c_id,evalute);
        return fale;
    }

}
