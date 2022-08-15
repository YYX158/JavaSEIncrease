package atyyx.lambda;

import atyyx.pojo.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.relational.core.sql.In;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author yyx
 * @version 1.0
 * @data 2022/8/9 18:58
 */
public class jiekouTest {

    @Test
    @DisplayName("消费者接口测试")
    public void test1()
    {
        Consumer<String> consumer=System.out::print;
        consumer.accept("张三");
    }

    @Test
    @DisplayName("供给接口测试")
    public void  test2()
    {
        Supplier<Person> supplier= Person::new;
        Person person = supplier.get();
        System.out.println(person);
    }

    @Test
    @DisplayName("函数型接口")
    public void test3()
    {
        Function<String,Person> function=Person::new;
        Person person1 = function.apply("张三");
        System.out.println(person1);

        Function<Integer,Person> function1=Person::new;
        Person person2 = function1.apply(22);
        System.out.println(person2);
    }

    @Test
    @DisplayName("断言接口测试")
    public void test4()
    {
        Predicate<String> predicate=String::isEmpty;
        boolean b = predicate.test("zhangsan");
        System.out.println(b);
    }

    @Test
    @DisplayName("断言接口测试")
    public void test5()
    {
        String str="123";
        Predicate<String> predicate=str::equals;
        boolean b = predicate.test("zhangsan");
        System.out.println(b);
    }

    @Test
    @DisplayName("数组使用")
    public void test6()
    {
        Function<Integer,Person[]> function =Person[]::new;
        Person[] apply = function.apply(8);
        for (int i = 0; i < apply.length; i++) {
            System.out.println(apply[i]);
        }
    }

    @Test
    public void test7()
    {
        BiPredicate<Integer,Integer> biPredicate=Integer::equals;
        boolean test = biPredicate.test(1, 3);
        System.out.println(test);

    }

    @Test
    public void test8()
    {
        List<Integer> list= Arrays.asList(1,3,4,6,5,7);

        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        System.out.println("************************************************************************");
        // 生成
        Stream.generate(Math::random).limit(20).forEach(System.out::println);

    }

    @Test
    @DisplayName("用数组去创建流")
    public void test9()
    {
        Function<Integer,Integer[]> function=Integer[]::new;
        Integer[] integers = function.apply(10);
        for (int i = 0; i < integers.length; i++) {
            integers[i]=(int) (Math.random()*100 %100);
        }
        Stream<Integer> integerStream = Arrays.stream(integers);

        integerStream.filter(s->s>60).forEach(s-> System.out.print(s+" "));

    }

    @Test
    public void test10()
    {
       List<Integer> list=Arrays.asList(3,4,5,7,2,3,4,5,0,9,3,3);

       list.stream().limit(3).forEach(System.out::println);

        System.out.println("**********************************************************************");

        list.stream().skip(3).forEach(System.out::println);

        System.out.println("**********************************************************************");

        System.out.println(list.stream().filter(s -> s.equals(3)).count());
    }


    @Test
    public void  test11()
    {
        List<String> list = Arrays.asList("aaaa", "bbbbb", "cc", "dd", "ee");

        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        System.out.println("**********************************************************************");

        list.stream().filter(str->str.length()>3).forEach(System.out::println);
    }

    @Test
    public void test12()
    {
//        ArrayList<Integer> list1 = new ArrayList<>();
        List<Integer>list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);

        System.out.println("********************************************************************************");

        List<Integer>list2 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println(list2);

        System.out.println("********************************************************************************");

        list1.addAll(list2);
        System.out.println(list1);

        System.out.println("********************************************************************************");

        //java.util.Arrays$ArrayList是Arrays类内的嵌套类。 它是数组支持的固定大小或不可变列表。
        List<Integer> list3=Arrays.asList(0,1,2,3,4,5);
        System.out.println(list3);

        System.out.println("********************************************************************************");

//        list3.addAll(list1);
//        System.out.println(list3);

        System.out.println("list1的数据类型是"+list1.getClass());
        System.out.println("list3的数据类型是"+list3.getClass());


    }

    @Test
    public void test13()
    {
        List<Integer>list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(5);
//        list1.add(7);
//        list1.add(9);
//        list1.add(3);
//
//        list1.stream().sorted().forEach(System.out::print);

        List<Employee> employees=EmployeeData.getEmployees();
//        employees.stream().forEach(System.out::println);

        System.out.println("********************************************************************************");

        employees.stream().sorted((e1,e2)->{
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if(compare!=0) return compare;
            else return Double.compare(e1.getSalary(),e2.getSalary());
        }).forEach(System.out::println);

    }
}
