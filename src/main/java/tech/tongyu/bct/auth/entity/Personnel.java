package tech.tongyu.bct.auth.entity;



import com.sun.javafx.beans.IDProperty;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.format.annotation.DateTimeFormat;

public class Personnel {

	private int id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private String timeup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeup() {
		return timeup;
	}
	public void setTimeup(String timeup) {
		this.timeup = timeup;
	}

	
	
	

}
