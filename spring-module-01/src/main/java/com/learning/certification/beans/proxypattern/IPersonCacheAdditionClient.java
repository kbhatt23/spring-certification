package com.learning.certification.beans.proxypattern;

public class IPersonCacheAdditionClient {
//public static void main(String[] args) {
//	useCacheUsingProxy();
//}
public static void useCacheUsingProxy() {
	IPersonDAO personDAO = new PersonDAOImpl();
	System.out.println("main method recieved all items: "+personDAO.findAll());
	System.out.println("main method recieved all items: "+personDAO.findAll());
	System.out.println("main method recieved all items: "+personDAO.findAll());

//adding filters/secutiry proxy
	IPersonDAO proxy = new PersonDAOProxy(personDAO);
	
	System.out.println("proxy method recieved all items: "+proxy.findAll());
	System.out.println("proxy method recieved all items: "+proxy.findAll());
	System.out.println("proxy method recieved all items: "+proxy.findAll());
}
}
