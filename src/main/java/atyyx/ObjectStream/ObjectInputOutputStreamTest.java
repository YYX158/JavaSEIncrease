package atyyx.ObjectStream;

import atyyx.pojo.Person;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 *
 * 2.作用
 * 用户存储和读取基本数据类型或者对象的处理流。
 * 他的强大之处就是可以把Java中的对象存储到磁盘中
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化的过程
     * 将内存中的java对象保存到磁盘中或者通过网络传输出去
     * 使用ObjectOutputStream实现
     *
     * 要想一个java对象是可序列化的，那么需要满足这些条件
     */
    @Test
    public void test1() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("obj.dat")));

        Person yyx = new Person("yyx", 22);
        //oos.writeObject(new java.lang.String("123"));
        oos.writeObject(yyx);

        oos.flush(); //刷新

        oos.close();
    }

    /**
     * 反序列化:将磁盘文件中的对象还原为内存中的一个java对象
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("obj.dat")));
        Object obj = ois.readObject();
        Person str=(Person)obj;
        //String str=(String)obj;
        System.out.println(str);
        if(ois!=null)
          ois.close();

    }
}
