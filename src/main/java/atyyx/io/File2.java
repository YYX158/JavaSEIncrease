package atyyx.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

public class File2 {
    public static void main(String[] args) {
        // 用main方法的时候，相对路径是相对于当前工程来说的
        File file = new File("iostream" + File.separator + "a.txt");

        FileReader fr = null;
        try {
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            // char也是int的一种
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read(); //在读一个
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        //1.实例化File类的对象，需要指明要操作的文件名
        // 用@Test的时候，当前路径就是在当前模块当中
        File file = new File("a.txt");

        FileReader fr = null;
        try {
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            // char也是int的一种
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read(); //在读一个
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("read()的重载方法")
    public void testFileReader1() {
        //1.File类的实例化对象
        File file = new File("a.txt");
        //2.FileReader流的实例化
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            //3.读入的操作
            // read(char[] cbuf):返回每次读入cbuf数组的字符个数
            //如果达到文件末尾，就返回-1
            char[] ch = new char[5];

            int len = 0;
            while ((len = fr.read(ch)) != -1) {
//                for (int i = 0; i < len; i++)
//                {
//                    System.out.print(ch[i]);
//                }
                String str = new String(ch, 0, len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }


        //4.流资源的关闭


    }

    /**
     * 输出操作，这个对应的file是可以不存在的
     * 如果不存在的话，在输出的时候，就会创建此文件
     */
    @DisplayName("FileWriter函数")
    @Test
    public void testFileWrite() {
        //1.提供File类的对象，指明写出到的文件
        // 文件写出的时候，如果文件不存在的话，那么就会自动创建
        File file = new File("b.txt");


        FileWriter fw = null;
        try {
            //2.提供FileWriter对象，用于数据的写出
            fw = new FileWriter(file, false);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream.");
            System.out.println("文件输入成功");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //4.资源流的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("文件输入输出函数测试")
    public void testFileReaderAndWriter() throws IOException {
        //1.创建File类对象，指明读入和写出的文件
        File fileReader = new File("a.txt");
        File fileWriter = new File("b.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            //2。创建输入流和输出流的对象
            fr = new FileReader(fileReader);
            fw = new FileWriter(fileWriter);

            //3.数据的读入和写出的操作
            char[] ch = new char[10];
            int len = 0; //计入每次读到ch数组中的字符的个数
            while ((len = fr.read(ch)) != -1) {
                // 每次写出len个字符
                fw.write(ch, 0, len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        //4.关闭流资源
    }


    @Test
    @DisplayName("字节流的使用")
    public void InputStreamAndWriterStream()
    {
        //1.创建File类对象，指明读入和写出的文件
        File fileReader = new File("宝贝.jpeg");
        File fileWriter = new File("宝贝1.jpeg");

        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            //2。创建输入流和输出流的对象
            fr = new FileInputStream(fileReader);
            fw = new FileOutputStream(fileWriter);

            //3.数据的读入和写出的操作
            byte[] ch = new byte[10];
            int len = 0; //计入每次读到ch数组中的字符的个数
            while ((len = fr.read(ch)) != -1) {
                // 每次写出len个字符
                fw.write(ch, 0, len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


    public void copy(String path1,String path2)
    {
        //1.创建File类对象，指明读入和写出的文件
        File fileReader = new File(path1);
        File fileWriter = new File(path2);

        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            //2。创建输入流和输出流的对象
            fr = new FileInputStream(fileReader);
            fw = new FileOutputStream(fileWriter);

            //3.数据的读入和写出的操作
            byte[] ch = new byte[1024];
            int len = 0; //计入每次读到ch数组中的字符的个数
            while ((len = fr.read(ch)) != -1) {
                // 每次写出len个字符
                fw.write(ch, 0, len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("测试copy函数")
    public void testCopy()
    {
        long start = System.currentTimeMillis();
        copy("a.txt","c.txt");
        long end = System.currentTimeMillis();
        System.out.println("复制操作需要花费的时间:"+(end-start)+"ms");
    }
}
