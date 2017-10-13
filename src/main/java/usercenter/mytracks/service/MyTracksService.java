package usercenter.mytracks.service;

import domain.Data;
import usercenter.mytracks.dao.MyTracksDao;

/**
 * MyTracksService，我的足迹的Service
 */
public class MyTracksService {
    /**
     * myCollect方法，查询我的收藏记录
     * @param u_id
     */
    public Data myCollect(Data data, String u_id) {

        //创建MyTracksDao对象
        MyTracksDao myTracksDao = new MyTracksDao();
       data = myTracksDao.myCollect(data,u_id);


        return data;
    }

    /**
     * myDownload方法，查询我的下载记录
     * @param data
     * @param u_id
     * @return
     */
    public Data myDownload(Data data, String u_id) {

        //创建MyTracksDao对象
        MyTracksDao myTracksDao = new MyTracksDao();
        data = myTracksDao.myDownload(data,u_id);

        return data;
    }

    /**
     * myUpload方法，查询我的上传记录
     * @param data
     * @param u_id
     * @return
     */
    public Data myUpload(Data data, String u_id) {

        //创建MyTracksDao对象
        MyTracksDao myTracksDao = new MyTracksDao();
        data = myTracksDao.myUpload(data,u_id);

        return data;
    }

    public void doDelMyDownload(String r_id, String u_id) {

        //创建MyTracksDao对象
        MyTracksDao myTracksDao = new MyTracksDao();
        myTracksDao.delMyDownload(r_id,u_id);

    }

    public void doDelMyUpload(String r_id, String u_id) {

        //创建MyTracksDao对象
        MyTracksDao myTracksDao = new MyTracksDao();
        myTracksDao.delMyUpload(r_id,u_id);

    }
}
