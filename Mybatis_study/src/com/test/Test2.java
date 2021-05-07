package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;

public class Test2 {
	//根据name字段模糊
	public static void main(String[] args){
		try {
			//读取配置文件
			InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
			//创建SqlSessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//创建SqlSession对象（核心对象，包含了所有对数据库操作的方法）
			SqlSession sqlsession = factory.openSession();
			//接受查询语句返回得类型
			List<Student> stus = sqlsession.selectList("com.mapper.StudentMapper.selectId2", "yy");
			//输出，看效果
			for(Student stu:stus){
				System.out.println(stu.getName());
			}
			//关闭SqlSession，以免影响系统性能
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
