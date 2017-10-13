package studyarea.resource.dao;

import domain.Resource;

import java.util.ArrayList;

/**
 *查询资源详情dao的接口
 * Created by huangwei on 17-7-24.
 */
public interface ResourceDao {
    //查询资源详情的方法
    public Resource ckDetails(String r_id);
    //查询资源是否已收藏的方法
    public boolean ckCollect(String r_id,String u_id);
    //添加收藏的方法
    public boolean addCollect(String r_id,String u_id);
    //删除收藏的方法
    public boolean deleteCollect(String r_id,String u_id);
    //查询点赞的方法
    public boolean ckLike(String r_id,String u_id);
}
