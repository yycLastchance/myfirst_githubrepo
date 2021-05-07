package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test5 {
	//删除学生信息
	public static void main(String[] args){
		try {
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			SqlSession sqlsession = factory.openSession();
			
			//delete and update的返回值都是int，即受影响的行数，在不能看数据库表的情况下，可以这样验证
			int result = sqlsession.delete("com.mapper.StudentMapper.deleteId",108);
			if(result>0){
				System.out.print("删除成功");
			}
			
			sqlsession.commit();
			
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
