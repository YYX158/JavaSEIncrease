package atyyx.Network;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源的地址
 * 2.格式
 * http://localhost:8080/examples/beauty.jpg?username=Tom
 * 协议    主机名     端口号   资源地址           参数列表
 */
public class URLTest {

    @Test
    @DisplayName("URL测试")
    public void test1()
    {
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
            // 获取该URL的协议名
            System.out.println("url的协议名:"+url.getProtocol());
            // 获取该url的主机名
            System.out.println("url的主机名是："+url.getHost());
            //获取端口号
            System.out.println("端口号:"+url.getPort());
            // 获取该URL的文件路径
            System.out.println("文件路径"+url.getPath());
             // 获取该URL的查询名
            System.out.println("查询名："+url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
