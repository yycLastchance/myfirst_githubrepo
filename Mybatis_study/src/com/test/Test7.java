package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Person;
import com.pojo.Student;

public class Test7 {
	//һ��һ����
		public static void main(String[] args){
			try {
				//��ȡ�����ļ�
				InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
				//����SqlSessionFactory����
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
				//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
				SqlSession sqlsession = factory.openSession();
				//���ܲ�ѯ��ϢList
				List<Person> list = sqlsession.selectList("com.mapper.PersonMapper.onetoone");
				for(Person per:list){
					System.out.println(per.getName()+" "+per.getNum()+" "+per.getCard().getCardnum());
				}
				//�ر�SqlSession������Ӱ��ϵͳ����
				sqlsession.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
