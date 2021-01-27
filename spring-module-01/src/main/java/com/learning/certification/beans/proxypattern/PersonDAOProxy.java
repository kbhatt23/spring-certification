package com.learning.certification.beans.proxypattern;

import java.util.List;

public class PersonDAOProxy implements IPersonDAO {

	//cahce addition of list of all items
	private static List<String> items;
	
	private IPersonDAO personDAOImpl;

	public PersonDAOProxy(IPersonDAO personDAOImpl) {
		this.personDAOImpl = personDAOImpl;
	}

	@Override
	public void save(String str) {
		System.out.println("PersonDAOProxy: filtering save contract");
		personDAOImpl.save(str);
		System.out.println("PersonDAOProxy: proxy cleared for save contract");
	}

	@Override
	public String findById(Integer id) {
		System.out.println("PersonDAOProxy: filtering save contract");
		String findById = personDAOImpl.findById(id);
		System.out.println("PersonDAOProxy: proxy cleared for save contract");
		return findById;
	}

	@Override
	public List<String> findAll() {
		if(items == null) {
		items=	personDAOImpl.findAll();
		}
		
		return items;
	}

}
