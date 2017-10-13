package utils;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程下载的方法
 * Created by huangwei on 17-7-26.
 */
public class Download {
    // 下载资源存入本地文件目录，如果这个文件不存在就创建
    private File file;
    //创建线程数具体这个线程为什么要用final修饰可能是这个线程要最终控制个数不能进行
    //线程随意改动,这里将线程设为10个线程
    private  int threadnum = 10;
    //确定下载到哪里确定下载目录
    private String dowdloadpath ="";
    // 定义变量确定每个每个线程下载多少
    private int threadLen;
    //定义下载时间
    private String data;

    //无参构造
    public Download(){

    }

    public void doDownload(String r_id,String r_name,String r_URL,String r_type) throws IOException, InterruptedException{
        //下载目录每个用户的下载目录不同
        dowdloadpath="/home/huangwei/download/"+r_id;
        //指定下载的路径
        File dir = new File(dowdloadpath);
        //判断如果路径目录不存在就创建
        if(!dir.exists()){
            dir.mkdirs();
        }

        //为下载文件取名
        String filename=r_name+"."+r_type;
        //根据file对象和抽象路径名创建新的路径
        file = new File(dir, filename);
        //建立URL链接
        //创建URL对象将
        URL url = null;
        try {
            url = new URL(r_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //建立链接返回返回一个 URLConnection对象,然后强转成HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置一个指定的超时值（以毫秒为单位），该值将在打开到此 URLConnection 引用的资源的通信链接时使用。
        // 如果在建立连接之前超时期满，则会引发一个 java.net.SocketTimeoutException。超时时间为零表示无穷大超时。
        conn.setConnectTimeout(5000);
        //获取这个链接文件的大小
        int totalLen = conn.getContentLength();
        //文件分块, 计算每个线程要下载的长度:文件分块大小（blockSize）= （文件大小 +线程数 - 1 ）/ 线程数
        threadLen = (totalLen + threadnum - 1) / threadnum;
        //输出测试一下大小和线程大小
        //System.out.println("totalLen="+totalLen+",threadLen:"+threadLen);
        // 在本地创建一个和服务端大小相同的文件
        //创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定。
        //值含意

        //"r"	 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
        //"rw"	 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
        //"rws"	 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
        //"rwd"  	 打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        // 设置文件的大小要合下载文件大小一样
        raf.setLength(totalLen);
        //关闭此随机访问文件流并释放与该流关联的所有系统资源。
        raf.close();
        // 开启多条线程, 每个线程下载一部分数据到本地文件中
        DownloadThread downloadThread = null;
        //创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
        ExecutorService exec = Executors.newCachedThreadPool();
        //进行循环开启线程
        for (int i = 0; i < threadnum; i++) {
            //创建多线程下载对象i线程数,将每个线程的个数 长度 地址传入;
            downloadThread=new DownloadThread(i, threadLen, file,url);
            //开启线程
            downloadThread.start();
            //提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
            // 该 Future 的 get 方法在成功 完成时将会返回 null。
            //参数：
            //task - 要提交的任务
            //返回：
            //表示任务等待完成的 Future
            exec.submit(downloadThread);
        }
        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        exec.shutdown();
        //进行死循环判断线程是否
        while(true){
            //如果关闭后所有任务都已完成，则返回 true。
            if(exec.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(1000);
        }
        Thread.sleep(5000);
        //定义结束时间
        //long endtime=System.currentTimeMillis();
        //计算用时
        //long time= endtime-startime;
        //如果线程关闭就将数据存在javabean中
        //System.out.println(time);
//        if (exec.isTerminated()){
//            String date="下载成功";
//            //Down down=new Down(r_name,totalLen,threadnum,date,data,time,r_URL,dowdloadpath);
//            //返回javabean
//            //return down;
//        }else{
//            String date="下载失败";
//            //Down down=new Down(r_name,totalLen,threadnum,date,data,r_URL);
//            return down;
//        }
        //return ;
    }
}
