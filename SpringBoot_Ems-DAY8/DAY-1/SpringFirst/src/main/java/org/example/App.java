package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
//        System.out.println( "Hello World!" );
//        Student s = new Student();
//        s.internshipProgram();
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) context.getBean("st");
        s.internshipProgram();
        context.getBean("fun");
        SpringBoot f = (SpringBoot) context.getBean("fun");
        f.hello("Hello");
        Method1 m = (Method1) context.getBean("m1");
        m.print1();
        Method2 me = (Method2) context.getBean("m2");
        me.print2();
        Method3 met = (Method3) context.getBean("m3");
        met.print3();

    }
}
