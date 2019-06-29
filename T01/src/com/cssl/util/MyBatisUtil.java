package com.cssl.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * @author tym
 *
 */
public class MyBatisUtil {
	
	//单例
	private static SqlSessionFactory factory;
	
	static {		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
