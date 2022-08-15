package atyyx.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 一.流的直接分类
 * 1.操作数据单位：字节流，字符流
 * 2.数据的流向：输入流，输出流
 * 3.流的角色：节点流，处理流
 * <p>
 * 二。流的体系结构
 * 抽象基类                节点流（或者说文件流）          缓冲流（处理流的一种）
 * InputStream            FileInputStream            BufferedInputStream
 * OutputStream           FileOutputStream           BufferedOutputStram
 * Reader                 FileReader                 BufferedReader
 * Writer                 FileWriter                 BufferedWriter
 * <p>
 * <p>
 * 三.缓冲流
 * 1.常见的缓冲流
 * BufferedInputStream
 * BufferedOutputStram
 * BufferedReader
 * BufferedWriter
 * 2.作用：提供流的读取，提高写入的速度
 */
public class File3 {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        //1.造文件
        File fileReader = new File("宝贝.jpeg");
        File fileWriter = new File("宝贝1.jpeg");

        FileInputStream fr = null;
        FileOutputStream fw = null;

        BufferedInputStream br=null;
        BufferedOutputStream bw=null;

        try {
            //2.造流
            fr = new FileInputStream(fileReader);
            fw = new FileOutputStream(fileWriter);
            //3.造缓冲流
            br = new BufferedInputStream(fr);
            bw = new BufferedOutputStream(fw);

            //4.复制的细节：读取、写入
            byte[] ch=new byte[1024];
            int len=0;
            while((len=br.read(ch))!=-1)
            {
                bw.write(ch,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally
        {
            //5.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            // 我们关闭外层的流以后，内层的流会自动被关闭
            try {
                if(br!=null)
                   br.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                if(bw!=null)
                   bw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
