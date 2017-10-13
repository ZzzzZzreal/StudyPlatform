package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yrq on 17-7-26.
 */
public class NowDate {

    public String nowDate(){
        Date date=new Date();
        //日期格式化
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime=dateFormat.format(date);

        return datetime;
    }
}
