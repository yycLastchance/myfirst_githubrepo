package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test5 {
	//ɾ��ѧ����Ϣ
	public static void main(String[] args){
		try {
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			SqlSession sqlsession = factory.openSession();
			
			//delete and update�ķ���ֵ����int������Ӱ����������ڲ��ܿ����ݿ�������£�����������֤
			int result = sqlsession.delete("com.mapper.StudentMapper.deleteId",108);
			if(result>0){
				System.out.print("ɾ���ɹ�");
			}
			
			sqlsession.commit();
			
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
