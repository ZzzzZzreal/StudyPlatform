package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by huangwei on 17-7-26.
 */
public class DownloadThread extends Thread{
    private URL url;//资源URL
    private int id;//线程id
    private int threadLen;//资源大小
    private File file;//下载的路径
    public DownloadThread(int id, int threadLen, File file, URL url)
    {
        this.id = id;
        this.threadLen=threadLen;
        this.file=file;
        this.url=url;
    }

    public void run() {
        int start = id * threadLen;                     // 起始位置
        int end = id * threadLen + threadLen - 1;       // 结束位置
        long s =System.currentTimeMillis();
        long l=0l;
        System.out.println("线程下载长度范围---->" + id + ": " + start + "-" + end);

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Range", "bytes=" + start + "-" + end);     // 设置当前线程下载的范围

            InputStream in = conn.getInputStream();
            RandomAccessFile raf = new RandomAccessFile(file, "rws");
            raf.seek(start);            // 设置保存数据的位置

            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1)
                raf.write(buffer, 0, len);
            raf.close();
            long e=System.currentTimeMillis();
            l=e-s;
            System.out.println("线程---->" + id + "下载完毕"+"线程下载用时:"+l+"毫秒");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
