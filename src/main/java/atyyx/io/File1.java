package atyyx.io;

import java.io.*;

public class File1 {
    public static void main(String[] args) {
        BufferedReader br=null;
        BufferedWriter bw=null;
        // 创建 缓冲流对象：它 是 处理 流 ，是对节点流的包装
        try
        {
            br=new BufferedReader(new FileReader("d:"+File.separator+"test.txt"));
            bw=new BufferedWriter(new FileWriter("d:"+File.separator+"test.txt"));
            String str="hello,yyx";

            while((str=br.readLine())!=null)
            {
                bw.write(str);  // 一次写入一行的字符串
                bw.newLine(); //将分隔符写入
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                if(br!=null)
                    br.close();    // 关闭过滤流时 会自动关闭它所包装的底层节点流
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try
            {
                if(bw!=null)
                   bw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
