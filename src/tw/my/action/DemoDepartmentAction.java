package tw.my.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.my.model.Department;

public class DemoDepartmentAction {

	public static void main(String[] args) {
		// 
		

		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();
		//得到session facototy物件(資料庫物件)  (取得資源MetadataSources(serviceRegistry))
		//找到設定黨(註冊等等)
		SessionFactory factory= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session =factory.openSession();
		//開始一個交易
		session.beginTransaction();
		
		
		Department deptDepartment=new Department();
		deptDepartment.setDepname("RD");
		
		session.save(deptDepartment);
		
		//取得正在使用的交易物件
		session.getTransaction().commit();
		
		
		session.close();	
		factory.close();

	}

}
