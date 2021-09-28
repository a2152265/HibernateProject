package tw.my.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.my.model.Department;
import tw.my.util.HibernateUtil;

public class DemoDapartmemtAction4 {

	public static void main(String[] args) {
		// 用get current session方式   save()
		//session per request
		/*將1次Request內多個資料庫的存取動作都放在1
		 個Transaction內、使用1個Session物件來處理，當Request結束時則
		 Transaction即結束並關閉Session; 使用上需要謹慎考量關閉Session物
		 件的時間點以避免Lazy Initialization的問題*/
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
	     Session session=  factory.getCurrentSession();
	     
	     try {
	    	 session.beginTransaction();
	    	 //這邊做CRUD 
	    	 Department dept4=new Department();
	    	 dept4.setDepname("QA");
	    	 session.persist(dept4);
	    	 //建議是馬上flush 出去後和save的差別是沒回傳PK
	    	 session.flush(); 
	    	 
	    	 
	    	 session.getTransaction().commit();
	     }catch (Exception e) {
			// TODO: handle exception
	    	 session.getTransaction().rollback();
	    	 e.printStackTrace();
		}finally {

			HibernateUtil.closeSessionFactory();
		}
		
	}

}
