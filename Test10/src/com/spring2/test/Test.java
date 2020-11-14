package com.spring2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        String xml="com/spring2/test/bean2.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        System.out.println(applicationContext.getBean("bean2"));
    }
}
