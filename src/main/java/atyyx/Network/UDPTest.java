package atyyx.Network;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 */
public class UDPTest {
    /**
     * 发送端
     */
    @DisplayName("发送端")
    @Test
    public void sender() throws IOException {
        // 1.构造udp的套接字对象
        DatagramSocket socket = new DatagramSocket();
        //2.构造数据报
        String str=" 我以UDP的方式发送的";
        InetAddress inet=InetAddress.getLocalHost();
        byte[] data=str.getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,inet,9090);

        socket.send(packet);

        socket.close();
    }

    /**
     * 接收端
     */
    @Test
    @DisplayName("接收端")
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] data=new byte[100];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
