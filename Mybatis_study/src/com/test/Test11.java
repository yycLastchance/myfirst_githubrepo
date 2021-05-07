package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test11 {
	//��̬mysql�е�<where>Ԫ��
			public static void main(String[] args){
				try {
					//��ȡ�����ļ�
					InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
					//����SqlSessionFactory����
					SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
					//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
					SqlSession sqlsession = factory.openSession();
					//���ܲ�ѯ��Ϣ
					Student stu = new Student();
					stu.setStu_id(101);
					stu.setName("yy");
					Student stus = sqlsession.selectOne("com.mapper.StudentMapper.whereId",stu);
					System.out.print(stus.getStu_id()+" "+stus.getName()+" "+stus.getBirth());
					//�ر�SqlSession������Ӱ��ϵͳ����
					sqlsession.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
