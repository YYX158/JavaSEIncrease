package atyyx.ObjectStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile直接继承与java.lang.Object类
 * 实现了DataInput和DataOutput
 * RandomAccessFile即可以作为一个输入流，又可以作为一个输出流
 *
 * 如果 RandomAccessFile作为输出流的时候，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出的文件存在，则会对原来的文件进行覆盖，从头开始覆盖。
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile r1=null;
        RandomAccessFile r2=null;

        try {
            r1 = new RandomAccessFile(new File("a.txt"),"r");
            r2 = new RandomAccessFile(new File("b.txt"),"rw");

            byte[] buffer=new byte[1024];
            int len=0;
            while((len=r1.read(buffer))!=-1)
            {
                r2.write(buffer,0,len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if(r1!=null)
                    r1.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                if(r2!=null)
                    r2.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile r1=new RandomAccessFile("hello.txt","rw");
        r1.seek(3);
        r1.write("xyz".getBytes());
        r1.close();
    }

    /**
     * RandomAccessFile希望使用一种覆盖的小郭
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile r1=new RandomAccessFile("hello.txt","rw");
        r1.seek(3);
        //String str=new String();
        StringBuilder builder=new StringBuilder((int)new File("hello.txt").length());
        byte[] buffer=new byte[20];
        int len=0;
        while((len=r1.read(buffer))!=-1)
        {
           builder.append(new java.lang.String(buffer,0,len));
        }
        // 调回指针，写入"xyz"
        r1.seek(3);
        r1.write("xyz".getBytes());

        // 将StringBuilder中的数据写到文件中
        r1.write(builder.toString().getBytes());
        r1.close();

    }
}
