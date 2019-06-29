package com.cssl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

import com.cssl.pojo.Emp;

public interface EmpDao {
	
	public List<Emp> selectAll();
	

}
