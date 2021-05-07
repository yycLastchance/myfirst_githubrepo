package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Person;
import com.pojo.Student;

public class Test7 {
	//一对一测试
		public static void main(String[] args){
			try {
				//读取配置文件
				InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
				//创建SqlSessionFactory对象
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
				//创建SqlSession对象（核心对象，包含了所有对数据库操作的方法）
				SqlSession sqlsession = factory.openSession();
				//接受查询信息List
				List<Person> list = sqlsession.selectList("com.mapper.PersonMapper.onetoone");
				for(Person per:list){
					System.out.println(per.getName()+" "+per.getNum()+" "+per.getCard().getCardnum());
				}
				//关闭SqlSession，以免影响系统性能
				sqlsession.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
