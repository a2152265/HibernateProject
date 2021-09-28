package tw.my.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity @Table(name = "bookDetail")
public class BookDetail {   //自定義主鍵的生成策略 (因為這邊是關聯到外來鍵)
	@GenericGenerator(name = "generator", strategy = "foreigh",parameters = @Parameter(name="property",value="book"))
	@Id @Column(name = "ID")
	@GeneratedValue(generator = "generator") //產生值的方式用book的generator產生
	private int id;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@Column(name = "PUBLISHERADDRESS")
	private String publisheraddress;
	
	@OneToOne(fetch = FetchType.LAZY) //和book是1對1關係 且是延遲載入
	@PrimaryKeyJoinColumn  //因為是外來鍵 這邊用來做pk的關聯欄位
	private Book book;  //你中有我 我中有你
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisheraddress() {
		return publisheraddress;
	}
	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

}
