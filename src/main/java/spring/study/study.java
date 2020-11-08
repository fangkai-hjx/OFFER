package spring.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.Teacher;

/**
 * 一个重要的方法:AbstractApplicationContext下的refresh() 包含13个方法，弄懂了 spring 源码就懂了
 */
public class study {
    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("fangkai.xml");
        Teacher teacher = ac.getBean("teacher",Teacher.class);
        System.out.println(teacher.getAge());
        System.out.println(teacher.getName());
        System.out.println(teacher.getBeanName());
    }
}
