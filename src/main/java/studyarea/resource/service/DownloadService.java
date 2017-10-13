package studyarea.resource.service;

import domain.Resource;
import studyarea.resource.dao.impl.ResourceDaoImpl;
import utils.Download;

import java.io.IOException;

/**
 * 此类操作调用dao方法获取下载需要的资源url,名称，格式
 * 调用downloan方法 开启多线程下载
 * Created by huangwei on 17-7-26.
 */
public class DownloadService {
    public boolean service(String r_id,String u_id)  {
        boolean flag=false;
        //创建ResourceDaoImpl对象
        ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
        //调用ckURL()方法
        Resource resource=resourceDaoImpl.ckURL(r_id);
        //判断是否连接上数据库
        if (null==resource){
            flag=false;
            return flag;
        }else {
            flag=true;
            //获取资源的名称
            String r_name = resource.getR_name();
            //获取资源的URL
            String r_URL = "http://localhost:8080/" + resource.getR_URL();
            //获取资源的格式
            String r_type = resource.getR_type();
            //创建Download对象
            Download download = new Download();
            //调用doDownload()方法
            try {
                download.doDownload(r_id,r_name, r_URL, r_type);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //添加到下载表
            String del="1";
            resourceDaoImpl.addDownload(r_id,u_id,del);
            return flag;
        }


    }
}
