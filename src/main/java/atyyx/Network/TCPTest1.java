package atyyx.Network;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据在控制台上显示
 */
public class TCPTest1 {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建一个网络对象，指明服务器的ip跟端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            //2. 创建一个套接字对象，第一个参数是网络对象，第二个参数是要通信的进程号
            socket = new Socket(inet, 8899);
            //3. 创建一个输出流
            os = socket.getOutputStream();
            //4.进行写
            os.write("你好，我是客户端".getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (os != null)
                    os.close();
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
     * 服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器的socket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用accept()表示接口来自客户端的socket
            socket = serverSocket.accept();
            //3. 获取输入流
            is = socket.getInputStream();

            // 可能会有乱码
//        int len=0;
//        byte[] ch=new byte[1024];
//        while((len=is.read(ch))!=-1)
//        {
//           String str=new String(ch,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] ch = new byte[5];
            int len = 0;
            while ((len = is.read(ch)) != -1) {
                baos.write(ch, 0, len);
            }
            System.out.println(baos.toString());

            System.out.println("收到来自"+socket.getInetAddress().getHostAddress()+"的数据");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }
}
