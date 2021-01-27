package com.learning.certification.beans.proxypattern;

import java.util.List;

public interface IPersonDAO {

	void save(String str);
	
	String findById(Integer id);
	
	//showing for caching behavior can be implmeneted in proxy class
	List<String> findAll();
}
