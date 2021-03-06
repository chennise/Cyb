package com.my.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class StudentsTest {

		@Test
		public void testSchemaExport() {
			//创建配置对象
			Configuration	config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
					applySettings(config.getProperties()).buildServiceRegistry();
			//创建sessionFactory
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
			//创建session对象 
			Session session = sessionFactory.getCurrentSession();
			//创建SchemaExport对象
			SchemaExport export = new SchemaExport(config);
			
			//第一个参数表示生成表结构，第二个参数表示在控制台输出sql语句
			export.create(true, true);
			
		}
}




