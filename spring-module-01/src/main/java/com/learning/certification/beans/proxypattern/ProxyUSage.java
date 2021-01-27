package com.learning.certification.beans.proxypattern;

public class ProxyUSage {
//public static void main(String[] args) {
//	learnProxyManually();
//}

private static void learnProxyManually() {
	//old way without proxy
	
	IPersonDAO personDAO = new PersonDAOImpl();
	String item = "jai radha madhav";
	personDAO.save(item);
	
	System.out.println("main method recieved item "+personDAO.findById(1));

//adding filters/secutiry proxy
	IPersonDAO proxy = new PersonDAOProxy(personDAO);
	
	proxy.save(item);
	System.out.println("main method recieved item "+proxy.findById(1));
}
}
