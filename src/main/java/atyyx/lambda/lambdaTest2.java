package atyyx.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口  Consumer<T>         void accept(T t)
 * 供给型接口  Supplier<T>         T get()
 * 函数型接口  Function<T,R>       R apply(T t)
 * 断定型接口  Predicate<T>        boolean test(T t)
 *
 *
 * @author yyx
 * @data 2022/8/9 11:29
 * @version 1.0
 */
public class lambdaTest2 {

    @Test
    public void test1()
    {
//        happyTime(500, new Consumer<Double>() {
//            @Override
//            public void accept(Double aDouble) {
//                System.out.println("学习太累了，去天上人间买了一瓶矿泉水，价格为"+aDouble);
//            }
//        });
        happyTime(500,money-> System.out.println("学习太累了，去天上人间买了一瓶矿泉水，价格为"+money));
    }

    public void happyTime(double money, Consumer<Double> con)
    {
        con.accept(money);
    }

    @Test
    public void test2()
    {
        List<String> list= Arrays.asList("北京","厦门","福州","深圳","上海","普京","南京");
        List<String> list1 = filterString(list, s -> s.contains("京"));
        list1.stream().forEach(s -> System.out.println(s));
        System.out.println("****************************************************************");
        list.stream().filter(s -> s.contains("京")).forEach(s-> System.out.println(s));
        System.out.println("****************************************************************");
        list.stream().filter(s -> s.contains("京")).map(s -> s.contains("南")).forEach(s-> System.out.println(s));
    }

    /**
     * 根据你给的规则去过滤集合中的元素
     * @param list   是一个集合
     * @param pre    是一个规则
     * @return
     */
    public List<String> filterString(List<String> list, Predicate<String> pre)
    {
        List<String> filterList=new ArrayList<>();

        for(String s:list)
        {
            if(pre.test(s))
            {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
