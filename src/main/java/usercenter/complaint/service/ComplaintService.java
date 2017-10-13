package usercenter.complaint.service;

import domain.Data;
import usercenter.complaint.dao.ComplaintDao;

public class ComplaintService {


    public Data doAdd(Data data, String u_id, String character, String cp_content) {


            //创建ComplaintDao对象
            ComplaintDao complaintDao = new ComplaintDao();
            data = complaintDao.doAdd(data, u_id,cp_content);
            System.out.println("service complaint data：" + data);
        return data;
    }

    public Data doRead(Data data) {
        //创建ComplaintDao对象
        ComplaintDao complaintDao = new ComplaintDao();
         complaintDao.doRead(data);
        System.out.println("service complaint data：" + data);
        return data;
    }
}
