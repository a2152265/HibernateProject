package tw.my.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.my.model.HouseBean;
import tw.my.model.HouseBeanService;
import tw.my.util.HibernateUtil;

public class DemoHouseBeanServiceAction {

	public static void main(String[] args) {
		// 測試interface 是否成功
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction(); //開啟交易
			
			//main
			HouseBeanService hService=new HouseBeanService(session);
			System.out.println("=============下面做查詢全部==================");
			List<HouseBean> resultList=hService.selectAll();
			System.out.println("resultList: "+resultList);
			
			for(HouseBean hBean:resultList) {
				System.out.println("查詢全部=====>"+hBean.getHouseid()+" : "+hBean.getHousename());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
