package atyyx.pojo;

/**
 * Person想要序列化需要满足：
 * 必须实现Serializable或者Externalizable接口
 * 一般推荐使用Serializable接口
 * implements java.io.Serializable叫做标识接口，里面啥也没有
 * 而且必须要有 private static final long serialVersionUID = -6849794470754667710L;
 * 要保证内部的属性也都是可序列化的
 *
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * transient属于瞬态的
 */
public class Person  implements java.io.Serializable
{
    private static final long serialVersionUID = -6849794457754667710L;

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }
    public Person(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show()
    {
        System.out.println("我就试试");
    }
}
