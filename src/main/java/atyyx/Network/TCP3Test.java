package atyyx.Network;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * <p>
 * 例题3：从客户端发送文件给服务端，服务端保存到本地，并且返回“发送成功”这四个字给客户端
 * 并关闭相应的连接
 */
public class TCP3Test {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
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
            socket.shutdownOutput();

            is= socket.getInputStream();
            baos = new ByteArrayOutputStream();
            while((len=is.read(ch))!=-1)
            {
               baos.write(ch,0,len);
            }
            System.out.println(baos.toString());

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

            try {
                is.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if(baos!=null)
                    baos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 服务器端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        OutputStream os =null;
        try {
            //1.创建一个socket对象
            serverSocket = new ServerSocket(9090);
            //2.调用accept方法去接收从服务器发来的消息
            socket = serverSocket.accept();
            //3.获取从网络中过来的流资源
            is = socket.getInputStream();
            //4. 创建文件输出流（字节流）
            fos = new FileOutputStream(new File("宝贝3.jpeg"));
            //5. 为了避免出现乱码，使用ByteArrayOutputStream第三方辅助流
            baos = new ByteArrayOutputStream();
            //6.进行写入数据
            byte[] ch = new byte[5];
            int len = 0;
            while ((len = is.read(ch)) != -1) {
                fos.write(ch, 0, len);
            }
            // 服务器端给客户端一个反馈
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //7.关闭资源
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
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
