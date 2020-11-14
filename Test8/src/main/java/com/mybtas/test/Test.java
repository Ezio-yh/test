package com.mybtas.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.itheima.po.Customer;
/**
 * ���ų��������
 */
public class Test {
    /**
     * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
     */
//	@Test
    public void findCustomerByIdTest() throws Exception {
        // 1����ȡ�����ļ�
        String resource = "mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        // 2�����������ļ�����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3��ͨ��SqlSessionFactory����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4��SqlSessionִ��ӳ���ļ��ж����SQL��������ӳ����
        Customer customer = sqlSession.selectOne("com.itheima.mapper"
                + ".CustomerMapper.findCustomerById", 1);
        // ��ӡ������
        System.out.println(customer.toString());
        // 5���ر�SqlSession
        sqlSession.close();
    }

    /**
     * �����û�������ģ����ѯ�û���Ϣ�б�
     */
//	@Test
    public void findCustomerByNameTest() throws Exception{
        // 1����ȡ�����ļ�
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2�����������ļ�����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3��ͨ��SqlSessionFactory����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4��SqlSessionִ��ӳ���ļ��ж����SQL��������ӳ����
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
                + ".CustomerMapper.findCustomerByName", "j");
        for (Customer customer : customers) {
            //��ӡ��������
            System.out.println(customer);
        }
        // 5���ر�SqlSession
        sqlSession.close();
    }

    /**
     * ��ӿͻ�
     */
    @Test
    public void addCustomerTest() throws Exception{
        // 1����ȡ�����ļ�
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2�����������ļ�����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3��ͨ��SqlSessionFactory����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4��SqlSessionִ����Ӳ���
        // 4.1����Customer���󣬲���������������
        Customer customer = new Customer();
        customer.setUsername("rosej=1");
        customer.setJobs("student");
        customer.setPhone("13333533092");
        // 4.2ִ��SqlSession�Ĳ��뷽�������ص���SQL���Ӱ�������
        int rows = sqlSession.insert("com.itheima.mapper"
                + ".CustomerMapper.addCustomer", customer);
        // 4.3ͨ�����ؽ���жϲ�������Ƿ�ִ�гɹ�
        if(rows > 0){
            System.out.println("���ɹ�������"+rows+"�����ݣ�");
        }else{
            System.out.println("ִ�в������ʧ�ܣ�����");
        }
        // 4.4�ύ����
        sqlSession.commit();
        // 5���ر�SqlSession
        sqlSession.close();
    }

    /**
     * ���¿ͻ�
     */
//	@Test
    public void updateCustomerTest() throws Exception{
        // 1����ȡ�����ļ�
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2�����������ļ�����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3��ͨ��SqlSessionFactory����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4��SqlSessionִ�и��²���
        // 4.1����Customer���󣬶Զ����е����ݽ���ģ�����
        Customer customer = new Customer();
        customer.setId(4);
        customer.setUsername("rose");
        customer.setJobs("programmer");
        customer.setPhone("13311111111");
        // 4.2ִ��SqlSession�ĸ��·��������ص���SQL���Ӱ�������
        int rows = sqlSession.update("com.itheima.mapper"
                + ".CustomerMapper.updateCustomer", customer);
        // 4.3ͨ�����ؽ���жϸ��²����Ƿ�ִ�гɹ�
        if(rows > 0){
            System.out.println("���ɹ��޸���"+rows+"�����ݣ�");
        }else{
            System.out.println("ִ���޸Ĳ���ʧ�ܣ�����");
        }
        // 4.4�ύ����
        sqlSession.commit();
        // 5���ر�SqlSession
        sqlSession.close();
    }

    /**
     * ɾ���ͻ�
     */
//	@Test
    public void deleteCustomerTest() throws Exception{
        // 1����ȡ�����ļ�
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2�����������ļ�����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3��ͨ��SqlSessionFactory����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4��SqlSessionִ��ɾ������
        // 4.1ִ��SqlSession��ɾ�����������ص���SQL���Ӱ�������
        int rows = sqlSession.delete("com.itheima.mapper"
                + ".CustomerMapper.deleteCustomer", 4);
        // 4.2ͨ�����ؽ���ж�ɾ�������Ƿ�ִ�гɹ�
        if(rows > 0){
            System.out.println("���ɹ�ɾ����"+rows+"�����ݣ�");
        }else{
            System.out.println("ִ��ɾ������ʧ�ܣ�����");
        }
        // 4.3�ύ����
        sqlSession.commit();
        // 5���ر�SqlSession
        sqlSession.close();
    }

}

