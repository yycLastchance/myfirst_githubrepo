package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test13 {
	//��̬mysql�е�<foreach>Ԫ��
		public static void main(String[] args){
			try {
				//��ȡ�����ļ�
				InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
				//����SqlSessionFactory����
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
				//����SqlSession���󣨺��Ķ��󣬰��������ж����ݿ�����ķ�����
				SqlSession sqlsession = factory.openSession();
				//�����鸳ֵ��stu_id
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(101);
				list.add(103);
				//��������
				List<Student> stus = sqlsession.selectList("com.mapper.StudentMapper.foreachId", list);
				for(Student stu:stus){
					System.out.println(stu.getName());
				}
				//�ر�SqlSession������Ӱ��ϵͳ����
				sqlsession.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
