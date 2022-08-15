package atyyx.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.relational.core.sql.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yyx
 * @version 1.0
 * @data 2022/8/10 13:58
 */
public class StreamTest2 {

    @Test
    @DisplayName("终止操作——匹配与查找")
    public void test1()
    {
        List<Employee> employees= EmployeeData.getEmployees();
        boolean match = employees.stream().allMatch(s -> s.getAge() > 18);
        System.out.println("员工列表中所有的员工年龄都大于18岁吗？"+match);

        boolean match1 = employees.stream().anyMatch(s -> s.getSalary() > 3000);
        System.out.println("是否存在员工的工资大于3000元"+match1);

        boolean b = employees.stream().noneMatch(s -> s.getName().startsWith("雷"));
        System.out.println("是否没有员工的姓雷"+b);

        Optional<Employee> optional = employees.stream().findAny();
        System.out.println("返回任意一个员工："+optional);

        Optional<Employee> optional1 = employees.parallelStream().findAny();
        System.out.println("返回任意一个员工1："+optional1);

        Optional<Employee> maxSalary = employees.stream().max((s1, s2) -> Double.compare(s1.getSalary(), s2.getSalary()));
        System.out.println(maxSalary);
    }

    @Test
    @DisplayName("2-规约操作")
    public void test2()
    {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //1.计算1-10的自然数和
        // reduce 第一个参数是初始值
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //2.计算公司所有员工工资的综合
        List<Employee> employees= EmployeeData.getEmployees();
        Optional<Double> sum1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sum1);

    }

    @Test
    @DisplayName("收集操作")
    public void  test3()
    {
        //练习1：查找工资大于6000的员工，结果返回回一个list或set
        List<Employee> employees= EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        System.out.println(collect);
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        System.out.println(collect1);

    }
}
