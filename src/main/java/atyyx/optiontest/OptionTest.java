package atyyx.optiontest;

import atyyx.pojo.Boy;
import atyyx.pojo.Girl;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的
 * 常用的方法：ofNullable(T t)
 *           ofElse(T t)
 *           T get():明确知道就是非空对象
 *           boolean isPresent()： 可以先去判断试一下是否为空指针
 *
 *
 * @author yyx
 * @version 1.0
 * @data 2022/8/10 16:05
 */
public class OptionTest {

    /**
     * Optional.of(T t): 创建一个Optional实例对象，t必须非空
     * Optional.empty():创建一个空的Optional实例
     * Optional.ofNullable(T t): t 可以为null
     */
    @Test
    public void test1()
    {
        Girl girl = new Girl();
        // of(T t):必须保证t是非空的
        Optional.of(girl);
    }

    @Test
    public void test2()
    {
        Girl girl =null;
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        System.out.println(girlOptional);
        Girl girl1 = girlOptional.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);

    }

    public String getGirlName(Boy boy)
    {
        // 会出现空指针
        return boy.getGirl().getName();
    }

    @Test
    public void test3()
    {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    // 优化以后的getGirlName
    public String getGirlName1(Boy boy)
    {
        if(boy!=null)
        {
            Girl girl = boy.getGirl();
            if(girl!=null)
            {
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4()
    {
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    // 使用Optional类的getGirlName2
    public String getGirlName2(Boy boy)
    {
        Optional<Boy> boyOptionalo = Optional.ofNullable(boy);
        // T orElse(T other)
        Boy yyx = boyOptionalo.orElse(new Boy(new Girl("李雅琪")));
        Optional<Girl> girl = Optional.ofNullable(yyx.getGirl());
        Girl girl1 = girl.orElse(new Girl("迪丽热巴"));
        return girl1.getName();
    }

    @Test
    public void test5()
    {
        Boy boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);

    }
}
