package com.learning.certification.beans.proxypattern;

import java.util.Arrays;
import java.util.List;

public class PersonDAOImpl implements IPersonDAO{

	@Override
	public void save(String str) {
		System.out.println("PersonDAOImpl: saving item "+str);
	}

	@Override
	public String findById(Integer id) {
		System.out.println("PersonDAOImpl: finding item with id "+id);
		return "jai shree ram";
	}

	@Override
	public List<String> findAll() {
		System.out.println("PersonDAOImpl: finding all items");
		return Arrays.asList("sita-ram","radhe-shyam");
	}

}
