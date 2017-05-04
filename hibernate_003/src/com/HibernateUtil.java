package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private  static SessionFactory sessionfactory;
	private static Session session;
	
	static{
	Configuration config = new Configuration().configure(); // �������ö���
	@SuppressWarnings("deprecation")
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
			.applySettings(config.getProperties()).buildServiceRegistry();// �����������
	// �����Ự��������
			sessionfactory = config.buildSessionFactory(serviceRegistry);
	}
	public static SessionFactory getsessionfactory(){
		return sessionfactory;
	}
	public static Session getsession(){
		
		// �Ự����;
		session = sessionfactory.openSession();
		// ��������
	
		return session;	
	}
	
	public static void closesession(Session session){
		
		if(session!=null)
			session.close();// �رջỰ��
			sessionfactory.close();// �رջỰ������
		}
	}


