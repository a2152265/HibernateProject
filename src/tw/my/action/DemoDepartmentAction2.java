package tw.my.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.my.model.Department;
import tw.my.util.HibernateUtil;

public class DemoDepartmentAction2 {

	public static void main(String[] args) {
		// 加入工廠模式
		//開啟
		SessionFactory factory=HibernateUtil.getSessionFactory();
		

	//==========================================================
		Session session =factory.openSession();
		//開始一個交易
		session.beginTransaction();
		
		
		Department deptDepartment=new Department();
		deptDepartment.setDepname("HR");
		
		session.save(deptDepartment);
		
		//取得正在使用的交易物件
		session.getTransaction().commit();
		
		
		session.close();
	//==========================================================
		//關閉
		HibernateUtil.closeSessionFactory();

	}

}
