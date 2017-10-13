package studyarea.interact.questionarea.service.impl;

import studyarea.interact.questionarea.dao.imp.ListDaoImpl;
import studyarea.interact.questionarea.service.ListService;

import java.util.ArrayList;

/**
 * 列表servic的实现类
 * 调用dao 去查询数据库
 * Created by jaques on 17-7-25.
 */
public class ListServiceImpl implements ListService {

    public ArrayList check() {
        ListDaoImpl listDaoImpl=new ListDaoImpl();
        ArrayList arrayList=listDaoImpl.check();
        return arrayList;
    }
}
