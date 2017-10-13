package studyarea.notice.service;

import domain.Data;
import domain.Notice;
import studyarea.notice.dao.NoticeDao;

import java.util.List;

public class NoticeService {

    /**
     * doSelect方法，查询公告通知的方法
     * @return
     */
    public Data doSelect(Data data, String orderBy,String author,String isMore) {

        //创建NoticeDao对象
        NoticeDao noticeDao = new NoticeDao();
        try {
            if (null==orderBy){
                orderBy="time";
            }
           data = noticeDao.doSelect(data,orderBy,author,isMore);
            System.out.println("service 排序方式："+orderBy);

        } catch (NullPointerException e) {
            e.printStackTrace();
            //orderBy = "time";
           data = noticeDao.doSelect(data,orderBy,author,isMore);
            System.out.println("service 排序方式："+orderBy);
        }

        return data;
    }

    /**
     * doSelectDetail方法，查询公告通知详情的方法
     * @return
     */
    public Data doSelectDetail(Data data, String n_id) {

        //创建NoticeDao对象
        NoticeDao noticeDao = new NoticeDao();
       data = noticeDao.doSelectDetail(data,n_id);
        System.out.println("service notice详情data："+data);
        return data;
    }

    /**
     * doAdd方法，发布公告通知的方法
     * @param
     * @return
     */
    public Data doAdd(Data data,String u_id,String character,String n_title,String n_content){

        if (!"admin".equals(character)){
            data.setStatus("0");
            data.setNote("无此权限！！");
        }else {
            //创建NoticeDao对象
            NoticeDao noticeDao = new NoticeDao();
            data = noticeDao.doAdd(data, u_id,n_title,n_content);
            System.out.println("service delete详情data：" + data);
        }
        return data;
    }

    /**
     * doDelete方法，删除公告通知的方法
     * @param
     * @return
     */
    public Data doDelete(Data data, String n_id,String u_id,String character){

        if (!"admin".equals(character)){
            data.setStatus("0");
            data.setNote("无此权限！！");
        }else {
            //创建NoticeDao对象
            NoticeDao noticeDao = new NoticeDao();
            data = noticeDao.doDelete(data, n_id);
            System.out.println("service delete详情data：" + data);
        }
        return data;
    }
}
