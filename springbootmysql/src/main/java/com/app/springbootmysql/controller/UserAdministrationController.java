package com.app.springbootmysql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.app.springbootmysql.model.UserGroups;
import com.app.springbootmysql.model.Users;
import com.app.springbootmysql.service.UserAdministrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserAdministrationController {
	
	@Autowired
	private UserAdministrationService service;
	
	
	@RequestMapping(path="/registerUser",method=RequestMethod.POST)
	public Users registerUser(@RequestBody Users user) throws Exception{
		
		String tempUserName = user.getUserName();
		if (tempUserName != null && !"".equals(tempUserName)) {
			 String userName = service.fetchUserByUserName(tempUserName);
			 System.out.println("userName>>>>>."+userName);
			if(userName!=null && !"".equals(userName)){
				throw new Exception("user with "+userName+" is already exist");
			}
		}	
		
		Users obj = null;
		service.saveUser(user);
		return obj;
		
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public Users loginUser(@RequestBody Users user) throws Exception{
		String tempUserName = user.getUserName();
		String tempPass = user.getPassword();
		Users userObj = null;
		
		String strflag = service.checkUserLock(tempUserName);
		
		System.out.println("Lock Flag"+strflag);
		
		
		if("Y".equals(strflag)){
			throw new Exception("user with "+tempUserName+" is locked");

		}
		
		
		if(tempUserName != null && tempPass != null){
			userObj=service.fetchUserByUserNameAndPassword(tempUserName, tempPass);
		}
		if(userObj == null)
			throw new Exception("user with "+tempUserName+" does not exist");

		return userObj;
	}
	
	
	@RequestMapping(path="/getUserList", method=RequestMethod.GET)
	public List<Users> fetchUserList(){
		
		List<Users> users = new ArrayList<Users>();
		
		//logic to fetch users from List
		
		users = service.fetchUserList();
		return users;
		
	}
	
	@RequestMapping(path="/getUserById/{id}", method=RequestMethod.GET)
	public Users fetchUserById(@PathVariable int id){
		
		return service.fetchUserById(id).get();
		
	}
	
	@DeleteMapping(path="/deleteUserById/{id}")
	public String deleteUserById(@PathVariable int id){
		
		return service.deleteUserById(id);
		
	}
	
	@GetMapping(path="/lockUnlockUserById/{id}/{lock}")
	public String lockUnlockUserById(@PathVariable int id,@PathVariable String lock){
		
		return service.lockUnlockUserById(id,lock);
		
		
		
	}
	
	@RequestMapping(path="/addUserGroups",method=RequestMethod.POST)
	public UserGroups addUserGroups(@RequestBody UserGroups userGroups) throws Exception{
		
		
		UserGroups obj = null;
		service.saveUserGroups(userGroups);
		return obj;
		
	}
	
	@RequestMapping(path="/getUserGroupList", method=RequestMethod.GET)
	public List<UserGroups> fetchUserGroupList(){
		
		List<UserGroups> users = new ArrayList<UserGroups>();
		
		//logic to fetch users from List
		
		users = service.fetchUserGroupList();
		return users;
		
	}
	
	@DeleteMapping(path="/deleteUserGroupById/{id}")
	public String deleteUserGroupById(@PathVariable int id){
		
		return service.deleteUserGroupById(id);
		
	}
	
	
	
}
