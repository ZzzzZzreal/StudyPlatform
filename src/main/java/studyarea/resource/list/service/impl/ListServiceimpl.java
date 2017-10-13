package studyarea.resource.list.service.impl;

import studyarea.resource.list.dao.ListDao;
import studyarea.resource.list.dao.impl.ListDaoimpl;
import studyarea.resource.list.service.ListService;

import java.util.List;

/**
 *
 * 这个类为类表service接口的实现类
 * 创建对象
 * 调用dao方法对数据库进行查询
 * Created by hp on 17-7-25.
 */
public class ListServiceimpl implements ListService {
    public List listservice(String major,String gener) {
        //创建连接
        ListDao listDao=new ListDaoimpl();
        //调用方法
        List ss=listDao.listdao(major,gener);


        return ss;
    }
}
