package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test10 {
	//��̬mysql�е�<choose>��<when>��<otherwise>Ԫ��
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
				//stu.setStu_id(102);
				stu.setName("yrm");
				Student stus = sqlsession.selectOne("com.mapper.StudentMapper.chooseId",stu);
				System.out.print(stus.getStu_id()+" "+stus.getName()+" "+stus.getBirth());
				//�ر�SqlSession������Ӱ��ϵͳ����
				sqlsession.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
