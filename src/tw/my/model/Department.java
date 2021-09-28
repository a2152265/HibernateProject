package tw.my.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//用annotation的寫法 (取代hbm.xml這種額外寫的方式)
//這邊在定義映射關係mapping 
//下一步要去註冊 去cfg.sml 加入<mapping class="tw.my.model.Department"/>

@Entity
@Table(name="department")
public class Department {
	@Id @Column(name = "DEPID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depid;
	
	@Column(name = "DEPNAME")
	private String depname;
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	
	

}
