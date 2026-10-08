package in.pwskills.nitin.connectwithdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.nitin.Entity.Beginners;
import in.pwskills.nitin.utilpackage.UtilClass;

public class RetriveData {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Query<Beginners> query=null;
		Session session=UtilClass.getsesion();
		List<Beginners> list=null;
		query=session.createQuery("from in.pwskills.nitin.Entity.Beginners");
		list=query.getResultList();
		list.forEach(obj->System.out.println(obj));
	}
}
