package enty;

public class Users {
	private Integer id;
	private String name;
	private String pwd;
	private Integer sal;
	public Users() {
	}
	public Users(Integer id, String name, String pwd, Integer sal) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sal = sal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sal="
				+ sal + "]";
	}
	
}
