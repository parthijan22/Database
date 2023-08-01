package com.springbootdatabse.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

@Entity
public class Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@Size(min = 3, max = 20)
	private String username;

	private String password;
	//private String name;
	//private String mobile_number;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

//	public String getMobile_number() {
//		return mobile_number;
//	}
//
//	public void setMobile_number(String mobile_number) {
//		this.mobile_number = mobile_number;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* public int getId() { return id; } */

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Bean [username=%s, password=%s]", username, password);
	}

	public Bean() {
		// super();

	}
	
	  
	  public Bean(int id,String username, String password) { super(); this.id =id;
	  this.username =username; this.password = password; }
	 

}
