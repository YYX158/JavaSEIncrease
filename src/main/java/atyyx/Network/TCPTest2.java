package atyyx.Network;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务器，服务器将文件保存到本地
 */
public class TCPTest2 {

    /**
     * 客户端
     */
    @Test
    public void client()  {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            //1.造一个socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            //2.造一个流
            os = socket.getOutputStream();
            //3. 造一个文件文件输入流
            fis = new FileInputStream(new File("宝贝.jpeg"));
            // 4. 将读入的文件写出去
            byte[] ch = new byte[1024];
            int len = 0;
            while ((len = fis.read(ch)) != -1) {
                os.write(ch, 0, len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                if (os != null)
                    os.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 服务器端
     */
    @Test
    public void server() throws IOException
    {
        //1.创建一个socket对象
        ServerSocket serverSocket = new ServerSocket(9090);
        //2.调用accept方法去接收从服务器发来的消息
        Socket socket = serverSocket.accept();
        //3.获取从网络中过来的流资源
        InputStream is = socket.getInputStream();
        //4. 创建文件输出流（字节流）
        FileOutputStream fos=new FileOutputStream(new File("宝贝3.jpeg"));
        //5. 为了避免出现乱码，使用ByteArrayOutputStream第三方辅助流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //6.进行写入数据
        byte[] ch=new byte[5];
        int len=0;
        while((len=is.read(ch))!=-1)
        {
            fos.write(ch,0,len);
        }
        //7.关闭资源
        baos.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
