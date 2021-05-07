package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Classes;
import com.pojo.Person;
import com.pojo.Student;

public class Test8 {
	//һ�Զ����
			public static void main(String[] args){
				try {
					//��ȡ�����ļ�
					InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
					//����SqlSessionFactory����
					SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
					//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
					SqlSession sqlsession = factory.openSession();
					//���ܲ�ѯ��Ϣ
					Classes cla = sqlsession.selectOne("com.mapper.ClassesMapper.onetoduo",3);
					List<Student> stus = cla.getStus();
					for(Student stu:stus){
						System.out.print(stu.getName()+" "+stu.getSex()+" "+stu.getBirth()+" ");
						System.out.println(cla.getTeacher()+" "+cla.getNum());
					}
					//�ر�SqlSession������Ӱ��ϵͳ����
					sqlsession.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
