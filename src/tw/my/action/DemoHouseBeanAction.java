package tw.my.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.my.model.HouseBean;

public class DemoHouseBeanAction {

	public static void main(String[] args) {
		// 做有需要執行動作都在這裡做
		//使用hbm.xml的方式
		
		
		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();
		//得到session facototy物件(資料庫物件)  (取得資源MetadataSources(serviceRegistry))
		//找到設定黨(註冊等等)
		SessionFactory factory= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		//開啟
		Session session=factory.openSession();
		//開啟交易
		Transaction ts=session.beginTransaction();
		
		HouseBean hBean=new HouseBean();
		hBean.setHouseid(1001);
		hBean.setHousename("Happppppy Hosuse");
	
		session.save(hBean);
		
		ts.commit();
		//關閉交易
		session.close();
		factory.close();
		
	
	}

}
