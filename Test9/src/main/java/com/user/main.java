package com.user;

import com.dao.Mapper;
import com.test.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("测试");
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session= sessionFactory.openSession();
            Mapper mapper= (Mapper) session.getMapper(Mapper.class);
            List<User> list= mapper.GetAll();
            for (User arr: list) {
                System.out.println(arr.toString());
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
