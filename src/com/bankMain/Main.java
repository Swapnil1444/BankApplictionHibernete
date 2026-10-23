package com.bankMain;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class Main {

	
	public static void main(String[] args) {
		 try (Session session = HibernateUtil
	                .getSessionFactory()
	                .openSession()) {

	            System.out.println(
	                    "Hibernate connected successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            HibernateUtil.shutdown();
	        }
	    
	}
	
}
