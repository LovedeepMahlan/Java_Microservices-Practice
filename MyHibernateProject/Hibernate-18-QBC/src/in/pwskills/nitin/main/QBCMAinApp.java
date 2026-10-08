package in.pwskills.nitin.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Project;
import in.pwskills.nitin.util.HibernateUtil;

public class QBCMAinApp {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		try {
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Project> query=builder.createQuery(Project.class);
			Root<Project> root=query.from(Project.class);
			/*query.select(root);
			Query<Project> hquery=session.createQuery(query);
			List<Project> list=hquery.getResultList();
			list.forEach(System.out::println);*/
			
			//to write a Query where projid>1 and projid<5 ordered by desc projName;
			
			/*query.select(root).
				  where(builder.and(builder.ge(root.get("projId"), 1L),builder.le(root.get("projId"), 5L))).
				  orderBy(builder.desc(root.get("projName")));
			
			Query<Project> hquery=session.createQuery(query);
			List<Project> list=hquery.getResultList();
			list.forEach(System.out::println);*/
			
			//write a query where location in ('Austan','Denver') orderby projName;
			
			/*query.select(root).where(root.get("location").in("Austan","Denver")).
			orderBy(builder.asc(root.get("projName")));
			
			Query<Project> hquery=session.createQuery(query);
			List<Project> list=hquery.getResultList();
			list.forEach(System.out::println);*/
			
			query.select(root).where(builder.and(builder.between(root.get("teamSize"), 8, 13),builder.like(root.get("projName"), "%T"))).
				 orderBy(builder.asc(root.get("projName")));
		}catch(HibernateException hie) {
			hie.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
	}
	

}
