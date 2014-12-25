package cn.edu.nju.sj12.vo;

import cn.edu.nju.sj12.enums.Gender;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private Gender gender;
	
	public UserVO(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setGender(Gender gender){
		this.gender = gender;
	}
	
	public Gender getGender(){
		return this.gender;
	}
}
