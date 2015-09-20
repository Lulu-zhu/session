package hibernate_session;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class SessionTest extends TestCase {

	public void testHello1(){
		
		System.out.println("----SessionTest.Hello1(----");
//		this.assertEquals("hello", "hesllo");
	}
	
	public void testSave1(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			user = new User();
			user.setName("李四");
			user.setPassword("123");
			user.setCreateTime(new Date());
			user.setExpireTime(new Date());
			
//			persistent状态，属性发生改变的时候，数据库会同步
			session.save(user);
			
			user.setName("王五");
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			
		}finally{
			
			HibernateUtils.closeSession(session);
		}
		
//		detached状态
		user.setName("zhangsan");
		try{
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
}
