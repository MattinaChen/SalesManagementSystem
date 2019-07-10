package tech.tongyu.bct.auth.entity;

public class Company {
	
	private int id;	//id 序号
	private String name; //名称
	private int companyId; //公司的 id 表示营业部属于哪个公司
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public static void main(String[] args) {
		String name = "20190508";
		String name1 = name.substring(0,4);
		String name2 = name.substring(4,6);
		String name3 = name.substring(6);
		System.out.println(name1+"-"+name2+"-"+name3);
	}
	
}
