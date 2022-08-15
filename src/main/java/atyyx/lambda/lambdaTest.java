package atyyx.lambda;

import org.junit.jupiter.api.Test;

/**
 * @author yyx
 * #data 2022/8/9 10:57
 * @version 1.0
 * <p>
 * <p>
 * Lambda表达式的使用
 * 1.举例： (o1,o2)->Integer.compare(o1,o2);
 * 2.格式:
 * ->:Lambda表达式的操作符或者说是箭头操作符
 * ->左边：Lambda形参列表（其实就是接口中的抽象方法的形参列表）
 * ->右边：Lambda体（其实就是重写的抽象方法的方法体）
 * <p>
 * 3.Lambda表达式的使用（分6种情况）
 * <p>
 * <p>
 * 4.lambda表达式的本质：作为接口的实例
 * <p>
 * 5.当接口中只有一个抽象方法的时候，可以用@FunctionalInterface标识为函数式接口
 * <p>
 * 总结：
 * ->左边:lambda形参列表的参数类型可以省略（类型推断）：如果lambda形参列表只有一个参数，那么参数的类型可以不写
 * ->右边:lambda体应该用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句，一条语句的时候return可以省略）
 */
public class lambdaTest {
    @Test
    public void test1() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if (i % 2 == 0)
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };
        new Thread(runnable1).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0)
                    System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }).start();
    }
}
