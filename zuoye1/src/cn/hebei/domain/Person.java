package cn.hebei.domain;

public class Person {
	private String id;
	private String name;
	private String sex;
	private String age;
	private String dept;
	
	
	public Person(String id,String name,String sex,String age,String dept)
	{
		
		this.id =id;
		this.name =name;
		this.sex =sex;
		this.age =age;
		this.dept =dept;
		
		
	}
	
	
	Person(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
