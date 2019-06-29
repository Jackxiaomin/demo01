package com.cssl.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cssl.dao.EmpDao;
import com.cssl.pojo.Emp;
import com.cssl.util.MyBatisUtil;

public class JTest {
	
	private static SqlSessionFactory factory;
	private SqlSession session;
	private EmpDao edao;

	/**
	 * 在测试之前执行一次
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("@BeforeClass");
		factory = MyBatisUtil.getFactory();
	}
	
	/**
	 * 每个测试方法之前执行
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		//System.out.println("@Before");
		//获取到的session不会自动提交事务
		session = factory.openSession();
		edao = session.getMapper(EmpDao.class);
	}

	/**
	 * 加了个注释
	 */
	@Test
	public void testSelect() {
		List<Emp> selectAll = edao.selectAll();
		for (Emp emp : selectAll) {
			System.out.println(emp.getEmpno()+"\t"+emp.getEname()
			+"\t"+emp.getHiredate()+"\t"+emp.getSal());
		}	
	}
	
	/**
	 * 每次测试完都要执行
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		//System.out.println("@After");
		session.commit();
		session.close();
	}

	/**
	 * 测试完所有方法执行
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//System.out.println("@AfterClass");
		factory = null;
	}

	

	

	

}
