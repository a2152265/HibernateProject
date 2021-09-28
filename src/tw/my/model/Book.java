package tw.my.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "book") //關連到book
public class Book {
	
	@Column(name = "ID") //關聯到db的ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)//自動產生
	private int id;
	
	@Column(name = "BOOKNAME")
	private String bookname;
	
	@Column(name = "AUTHER")
	private String auther;
	
	@Column(name = "PRICE")
	private int price;
	
	//1對1的關係  (延遲載入(LAZY)  和db的book做關聯(mapping)  擬作甚麼我就做甚麼(cascadeALL))
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL )
	private BookDetail bookDetail;  //你中有我 我中有你
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public BookDetail getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
	
	
	
	 

}
