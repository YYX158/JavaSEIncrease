package atyyx.reflection;

import atyyx.pojo.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    @DisplayName("反射测试")
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clzz = Person.class;
        Constructor constructor = clzz.getConstructor(String.class, Integer.class);
        Object instance = constructor.newInstance("Tom", 22);
        Person person=(Person)instance;
        System.out.println(person);
        //调用属性
        Field age = clzz.getDeclaredField("age");
        age.set(person,19);
        System.out.println(person);

        Method show = clzz.getDeclaredMethod("show");
        show.invoke(person);

        Method getAge = clzz.getDeclaredMethod("getAge");
        Object getAge1 = getAge.invoke(person);
        System.out.println(getAge1);


    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        //constructor.setAccessible(true);
        Person person =(Person) constructor.newInstance("JAVA", 19);
        System.out.println(person);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"刘备");
        System.out.println(person);
    }
}
