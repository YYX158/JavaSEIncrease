package atyyx.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStream
{
    /**
     * 1.标准的输入流、输出流
     * System.in的输入流，默认是从键盘输入
     * System.out:标准的输出流，默认是在控制台输出
     *
     * System类的setIn(InputStream is) /  setOut(PrintStream ps) 方式重新指定输入和输出的方法
     *
     *
     * 练习：
     * 从键盘中输入字符串，要求将读取到的整行字符串转换成大写输出，
     * 然后继续进行输入操作
     * 直道输入"e"或者"exit"的时候，退出程序
     *
     *
     * 实现：
     * 方法一：使用Scanner类来实现，调用next()方法，返回一个字符串
     * 方法二：使用System.in来实现       System.in---->BufferedReader的readLine()
     */
    @Test
    public void test1() throws IOException {
        //1.创建一个转换流对象
        InputStreamReader isr = new InputStreamReader(System.in);
        //2.创建一个缓冲区对象
        BufferedReader br = new BufferedReader(isr);

        while(true)
        {
            System.out.println("请输入字符串:");
            String data=br.readLine();
            if("e".equalsIgnoreCase(data)|| "exit".equalsIgnoreCase(data))
            {
                System.out.println("程序已经结束了");
                break;
            }
            String s = data.toUpperCase();
            System.out.println(s);
        }
        if(br!=null)
           br.close();
    }

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //1.创建一个转换流对象
            InputStreamReader isr = new InputStreamReader(System.in);
            //2.创建一个缓冲区对象
            br = new BufferedReader(isr);

            while(true)
            {
                System.out.println("请输入字符串:");
                String data=br.readLine();
                if("e".equalsIgnoreCase(data)|| "exit".equalsIgnoreCase(data))
                {
                    System.out.println("程序已经结束了");
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if(br!=null)
                    br.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 打印流
     * PrintStream 和PrintWriter
     *
     * 提供了一系列的print跟println
     *
     * 练习：
     */
    @Test
    public void test2()
    {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("a.txt"));
            // 创建打印流，设置自动刷新模式（写入换行符或者字节'\n' 时都会刷新输出缓冲区
            ps=new PrintStream(fos,true);
            if(ps!=null) // 把标准输出流（控制台输出）改成文件
            {
                System.setOut(ps);
            }
            // 输出ASCLL字符
            for (int i = 0; i <= 255 ; i++)
            {
                System.out.print((char)i);
                if(i%50==0) // 每50个数据 换一行
                {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null)
              ps.close();
        }
    }


    /**
     * 3.数据流
     * DataInputStream和DataOutputStream
     * 作用：用于读取或者写出基本数据类型的变量或者字符串
     *
     * 练习：将内存中的字符串、基本数据类型写到文件中
     *
     */
    @Test
    public void test3() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("杨宇鑫");
        dos.flush(); //刷新操作：将内存中的数据写入文件
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    /**
     * 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序是一致的！
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name="+name);
        System.out.println("agee="+age);
        System.out.println("isMale="+isMale);

        dis.close();
    }
}
