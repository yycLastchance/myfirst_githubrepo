package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test4 {
	//����ѧ����Ϣinsert
	public static void main(String[] args){
		try {
			//��ȡ�����ļ�
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			//����SqlSessionFactory����
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
			SqlSession sqlsession = factory.openSession();
			//
			Student stu = new Student();
			stu.setStu_id(106);
			stu.setName("yod");
			stu.setSex("nv");
			sqlsession.update("com.mapper.StudentMapper.updateId", stu);
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
