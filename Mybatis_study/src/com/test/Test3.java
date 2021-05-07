package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test3 {
	//����ѧ����Ϣinsert
	public static void main(String[] args){
		try {
			//��ȡ�����ļ�
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			//����SqlSessionFactory����
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
			SqlSession sqlsession = factory.openSession();
			//�������
			/*Student stu = new Student();
			stu.setStu_id(106);
			stu.setName("abc");
			stu.setSex("nan");
			stu.setBirth("2002-02-15");
			stu.setClasses("4");*/
				//�ù��췽����ֵ
			Student stu = new Student(108,"qdp","nv","2025-03-14","3");
			sqlsession.insert("com.mapper.StudentMapper.insertId", stu);
			//�ύ����
			sqlsession.commit();
			//�ر�SqlSession������Ӱ��ϵͳ����
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
