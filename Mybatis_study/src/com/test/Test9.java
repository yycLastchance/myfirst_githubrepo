package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Classes;
import com.pojo.Student;

public class Test9 {
	//��̬sql <if>
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
			stu.setName("yy");
			//stu.setSex("nan");
			List<Student> stus = sqlsession.selectList("com.mapper.StudentMapper.idId",stu);
			for(Student st:stus){
				System.out.println( st.getName() );
			}
			
			//�ر�SqlSession������Ӱ��ϵͳ����
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
