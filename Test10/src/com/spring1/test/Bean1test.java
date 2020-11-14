package com.spring1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1test {
    public static void main(String[] args) {
        String xml="com/spring1/test/beans1.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        Bean1 bean1=(Bean1)applicationContext.getBean("bean");//这里指代的是配置文件中的id
        System.out.println(bean1);
    }
}
