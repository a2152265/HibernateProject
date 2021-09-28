package tw.my.action;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.my.model.HouseBean;
import tw.my.util.HibernateUtil;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Transation Begin");
			//Crud
			//新增資料 save方法
//			HouseBean houseBean2=new HouseBean();
//			houseBean2.setHouseid(1001);
//			houseBean2.setHousename("Happy HOuse");
//			session.save(houseBean2);
			
			//用load查詢資料
			//缺點是如果沒找到資料會出error然後rollback
//		 HouseBean resultBean=	session.load(HouseBean.class, 1001);
//		 System.out.println(resultBean.getHouseid()+" : "+resultBean.getHousename());
			
		 //用get方法
		//沒找到不會有error   較load優
//		 HouseBean resultBean2=	session.get(HouseBean.class, 1005);
//		 if (resultBean2!=null) {
//			 System.out.println("=====查找結果 : "+resultBean2.getHouseid()+" : "+resultBean2.getHousename());		
//		}else {
//			System.out.println("No result");
//		}
		 
		 //查詢多筆資料
		 //指定bean型別 和名稱
//		 Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
//         List<HouseBean> resultList = query.list();
//         System.out.println("===========上面是SQL語法==================");
//       //用list方法回傳結果
//         for(HouseBean hBean:resultList) {
//         	System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
//         }
//		System.out.println("===============================");
//		//另外一種展示list的方式
//		 Iterator<HouseBean> i1=resultList.iterator();
//		 while(i1.hasNext()) {
//			 HouseBean resultBean=i1.next();
//			 System.out.println(resultBean.getHouseid()+" : "+resultBean.getHousename());
//		 }
		 
//		 System.out.println("=========下面是刪除==========================");
//         //刪除資料
//		 HouseBean deleteBean=new HouseBean();
//		 deleteBean.setHouseid(1001);
////		 deleteBean.setHousename("Happy HOuse");  //這句可有可無
//		 session.delete(deleteBean);
			
			//更新資料
			//先新增一筆
//			HouseBean houseBean2=new HouseBean();
//			houseBean2.setHouseid(1003);
//			houseBean2.setHousename("Happyyy HOuse");
//			session.save(houseBean2);
//			System.out.println("新增成功 回傳"+houseBean2);
			//如果Session中已經存在與方法參數具有相同Primary Key的物件會出現錯誤訊息
			//即這兩bean物件如果同時出現就會有錯 暫解:每次的動作都用一次open/close
			//更新
			HouseBean updateBean=new HouseBean();
			updateBean.setHouseid(1003);
			updateBean.setHousename("Nice House");
			//update都是用id去識別(Pk)
			session.update(updateBean);
			
			
		 
		 
		 
		 
			session.getTransaction().commit();
			System.out.println("Transaction Commit了");
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			System.out.println("Transaction RollBack了");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
