package com;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Set;
import org.junit.Test;

public class testmany {

//������ϵ��ά����project����ά����	
  public static void main(String[] args){
	  
  }
  @Test
  public void add(){
	  Project project1=new Project(1001,"��Ŀһ");
	  Project project2=new Project(1002,"��Ŀ��");
	  Employee employee1=new Employee(1,"Ů��");
	  Employee employee2=new Employee(2,"����");
	  project1.getEmployees().add(employee1);
	  project1.getEmployees().add(employee2);
	  project2.getEmployees().add(employee1);
	  
	  	
	  Session  session=HibernateUtil.getsession();
	  Transaction transaction = session.beginTransaction();
	  session.save(project1);
	  session.save(project2);
	  transaction.commit();
	  HibernateUtil.closesession(session);
		  
  }
  @Test
  //��ѯԱ����Ϣ
  public  void find(){
	  Session  session=HibernateUtil.getsession();
	  Employee employee=(Employee)session.get(Employee.class, 2);
	  System.out.print(employee);
	  //evict�������һ�������е��ƶ�����
	  //session.evict(employee);
	  //clear���һ���������������
	  //session.clear();
	  //
			 
	    
  }
}
