package atyyx.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class File4
{
    @Test
    public void t1()
    {
        FileInputStream fis=null;
        InputStreamReader isr=null;
        try {
            // 1.创建字节流对象
           fis= new FileInputStream("a.txt");
            //2.创建转换流对象,第二个参数指明字符集
           isr= new InputStreamReader(fis,"UTF-8");

            char [] ch=new char[20];
            int len=0;
            while((len=isr.read(ch))!=-1)
            {
                String str=new String(ch,0,len);
                System.out.print(str);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if(isr!=null)
                    isr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.创建文件对象
            File file1 = new File("a.txt");
            File file2 = new File("b.txt");
            //2.创建流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //3.创建转换流
            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");
            //4.输入文件
            char[] ch=new char[20];
            int len=0;
            while((len=isr.read(ch))!=-1)
            {
               osw.write(ch,0,len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if(isr!=null)
                    isr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if(osw!=null)
                    osw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    @Test
    public void test3() throws IOException
    {
        File file = new File("a.txt");

        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        Map<Character,Integer> map =new HashMap<>();
        //char ch[]=new char[1];
        int len=0;
        while((len=br.read())!=-1)
        {
           if(map.get((char)len)==null)
           {
               map.put((char)len,1);
           }
           else
           {
               //Integer cnt=map.get((char)len);
              //map.remove(ch.toString());
              map.put((char)len,map.get((char)len)+1);
           }
        }
        //关闭文件
        if (br!=null)
            br.close();
        System.out.println("出现的频率如下：");
        System.out.println(map);
    }
}
