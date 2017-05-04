import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Students;

public class studenttest {

	private SessionFactory sessionfactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {

		Configuration config = new Configuration().configure(); // �������ö���
		// �����������
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// �����Ự��������
		sessionfactory = config.buildSessionFactory(serviceRegistry);
		// �Ự����;
		session = sessionfactory.openSession();
		// ��������
		
		transaction = session.beginTransaction();

	}

	@After
	public void destroy() {
		transaction.commit();// �ύ����
		session.close();// �رջỰ��
		sessionfactory.close();// �رջỰ������

	}

	@Test
	public void testwriteBlob() throws Exception {
		Students s = new Students(4, "�°�ѩ", "girl", new Date(), "����");
		File f=new File("e:"+File.separator+"ax.jpg");
		InputStream input =new FileInputStream(f);
		Blob image=Hibernate.getLobCreator(session).createBlob(input, input.available());
		s.setPicture(image);
		session.save(s);

	}
	@Test
	public void testReadBlob() throws Exception{
		Students s=(Students)session.get(Students.class, 4);
		Blob image=s.getPicture();
		InputStream input =image.getBinaryStream();//�����Ƭ����������
		File f=new File("e:"+File.separator+"cyb.jpg");//�����������
		OutputStream output=new FileOutputStream(f);//����������
		byte[] buff=new byte[input.available()];//������������
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
		
		
	}
	
}
