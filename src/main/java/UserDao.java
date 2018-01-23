import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import javax.servlet.http.HttpSession;

public class UserDao {

	
	
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static boolean find(User log) {
		String name = log.getUser();
		String password = log.getPassword();
		Session session = null;
		session = factory.openSession();
		String sql = "from User u where u.user='" + name + "' and u.password='" + password + "' and status = 1";
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		if (list.size() > 0) {
			log.setUserId(list.get(0).getUserId());
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	public static boolean saveUser(User u) {
		
		Session session = null;
		session = factory.openSession();
		session.beginTransaction();
		try {
			session.save(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return false;
		}
	}
	public static boolean saveOrUpdat(Profile u) {
		
		Session session = null;
		session = factory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return false;
		}
	}

	public static List<Profile> check(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		session = factory.openSession();
		String sql = "from Profile u where u.userId=" + id;
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Profile> list = query.list();
		session.close();
		return list;
		
	}


}
