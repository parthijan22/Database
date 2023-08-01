package com.springbootdatabse.database.beandetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Bean")
public class BeanDetails {
	

	@Id
	private String username;
	//private String password;
	private String name;
	private Integer mobile_number;
	/*
	 * private Integer id; public Integer getId() { return id; } public void
	 * setId(Integer id) { this.id = id; }
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Integer mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
	public BeanDetails() {
		super();
	}
	@Override
	public String toString() {
		return "BeanDetails [username=" + username + ", name=" + name
				+ ", mobile_number=" + mobile_number + "]";
	}
	
	
}
