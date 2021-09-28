package tw.my.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.my.model.HouseBean;
import tw.my.model.HouseBeanDao;
import tw.my.util.HibernateUtil;

public class DemoHouseDaoAction {

	public static void main(String[] args) {
		// opensession or get
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			//main
			HouseBeanDao hDao=new HouseBeanDao(session);			
			
			System.out.println("===========下面搜尋單筆資料=================");
			HouseBean resultBean = hDao.selectById(1002);
			if (resultBean!=null) {
				System.out.println("搜尋結果如下 ==> "+resultBean.getHouseid()+" : "+resultBean.getHousename());
			}else {
				System.out.println("NO RESULT");
			}
			
			System.out.println("===========下面新增=======================");
			
//			HouseBean saveBean=new HouseBean();
//			saveBean.setHouseid(1004);
//			saveBean.setHousename("yy House");
//			hDao.insert(saveBean);
			
			System.out.println("============下面更新========================");
			
			hDao.update(1002, "Funny House");
			
			System.out.println("=============下面刪除=========================");
			
//			hDao.deleteBtId(1003);
			
			
			System.out.println("===========下面查詢所有==========");
			List<HouseBean> resultList= hDao.selectAll();
			for(int i=0;i<resultList.size();i++) {
				HouseBean hBean=resultList.get(i);
				System.out.println((i+1)+". "+hBean.getHouseid()+" : "+hBean.getHousename());
				
			}
			System.out.println("===========================================");
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("錯誤 RollBack囉");
		}finally {
			//關閉工廠session
			HibernateUtil.closeSessionFactory();
		}

	}

}
