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
	//增加学生信息insert
	public static void main(String[] args){
		try {
			//读取配置文件
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			//创建SqlSessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//创建SqlSession对象（核心对象，包含了所有对数据库操作的方法）
			SqlSession sqlsession = factory.openSession();
			//插入语句
			/*Student stu = new Student();
			stu.setStu_id(106);
			stu.setName("abc");
			stu.setSex("nan");
			stu.setBirth("2002-02-15");
			stu.setClasses("4");*/
				//用构造方法赋值
			Student stu = new Student(108,"qdp","nv","2025-03-14","3");
			sqlsession.insert("com.mapper.StudentMapper.insertId", stu);
			//提交事务
			sqlsession.commit();
			//关闭SqlSession，以免影响系统性能
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
