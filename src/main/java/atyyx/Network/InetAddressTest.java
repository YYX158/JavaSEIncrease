package atyyx.Network;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一.网络编程中有两个主要的问题：
 * 如何准确地定位网络上一台或者多台主机；
 * 定位主机上的特定的应用
 * 2.找到主机后如何进行可靠高效地数据传输
 *
 * 二.网络编程中的两个要素
 * 1.对应问题一：IP和端口号
 * 对应问题二：提供网络通信协议：TCP/IP参考模型（应用层，传输层，网络层，物理+数据链路层）
 *
 */
public class InetAddressTest {
    @Test
    public void test1()
    {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
