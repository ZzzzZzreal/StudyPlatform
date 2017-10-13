package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zlc on 17-7-25.
 * 这个类用来自动生成id
 */
public class CreateID {
    /**
     * 用当前日期加上四位随机数可生成id
     * @return
     */
    public String createID(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String id=dateFormat.format(new Date(System.currentTimeMillis()));
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            id+=String.valueOf(random.nextInt(10));
        }
        return id;
    }
}
