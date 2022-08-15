package atyyx.io;

import java.io.*;

public class MyFile {
    public static void main(String[] args)
    {

//        File file1=new File("d:"+File.separator+"test.txt");
//        System.out.println("文件的长度是:"+file1.length());
//        System.out.println("文件的路径是:"+file1.getPath());
//        System.out.println("文件的上层目录是:"+file1.getParent());
//        System.out.println("获取最新一次修改的时间:"+ TimeUnit.MILLISECONDS.toDays(file1.lastModified()));
//
//        File file2=new File("d:");
//        System.out.println("是文件夹吗?"+file2.isDirectory());


        // 读文件
//        FileReader fr=null;
//        try
//        {
//            fr=new FileReader(new File("d:"+File.separator+"test.txt"));
//            char[] ch=new char[1024];
//            Integer len=0;
//            while((len=fr.read(ch))!=-1)
//            {
//                System.out.println(ch);
//            }
//        } catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                fr.close();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//
//        }

        // 写文件
        FileWriter fw=null;
        try
        {
            fw=new FileWriter(new File("d:"+ File.separator+"test.txt"),true);
            fw.write("\n welcome");
            System.out.println("文件书写完毕");

        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                fw.close();
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        }

    }
}
