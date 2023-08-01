package com.springbootdatabse.database;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springbootdatabse.database.beandetails.BeanDetails;




@Service
public class ServiceClass {
	/*
	 * private static List<Bean> details = new ArrayList<>();
	 * 
	 * public Bean findOne(String username) { for(Bean name:details) { if
	 * (name.getUsername().equals(username)) {
	 * 
	 * } else { return name; } } return null; }
	 */	
	
	
	    @Autowired
	    private UseRepository useRepository;

//	    public List<Bean> getBeanByUsername(String username,String password) 
//	    {
//	        return useRepository.findBeanByUsername(username,password);
//	    }
	    
	    public List<BeanDetails> getBeanByUsername(String username,String password) 
	    {
	        return useRepository.findBeanByUsername(username,password);
	    }

	
}