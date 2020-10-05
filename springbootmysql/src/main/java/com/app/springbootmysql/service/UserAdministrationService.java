package com.app.springbootmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbootmysql.model.UserGroups;
import com.app.springbootmysql.model.Users;
import com.app.springbootmysql.repository.UserAdministrationRepository;
import com.app.springbootmysql.repository.UserGroupAdministrationRepository;

@Service
public class UserAdministrationService {
	
	@Autowired
	private UserAdministrationRepository repo;	
	
	@Autowired
	private UserGroupAdministrationRepository repo1;	
	
	
	public Users saveUser(Users user){
		return repo.save(user);
	}
	
	public Users fetchUserByEmailId(String emailId){
		
		return repo.findByEmailId(emailId);
		
			
	}
	
	public Users fetchUserByUserNameAndPassword(String userName,String password){
		
		return repo.findUserByUserNameAndPassword(userName, password);
		
			
	}
	
	public List<Users> fetchUserList(){
		
		return repo.findAll();
		
		
	}
	
	public Optional<Users> fetchUserById(int id){
		
		return repo.findById(id);
		
			
	}

	
	public String deleteUserById(int id) {

		String result;
		try {
			repo.deleteById(id);

			result = "User Successfully deleted";
		} catch (Exception e) {
			result = "Error Occured while deleting user";

		}

		return result;

	}
	
	public String lockUnlockUserById(int id,String lock) {

		String result;
		try {
			repo.setCustomerName(id,lock);
		
			result = "User Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Error Occured while deleting user";

		}

		return result;

	}

	public String checkUserLock(String name) {

		return repo.findLockUserByName(name);
		

	}
	
	public UserGroups saveUserGroups(UserGroups userGroups){
		return repo1.save(userGroups);
	}
	
	public List<UserGroups> fetchUserGroupList(){
		
		return repo1.findAll();
		
		
	}
	
	public String deleteUserGroupById(int id) {

		String result;
		try {
			repo1.deleteById(id);

			result = "User Successfully deleted";
		} catch (Exception e) {
			result = "Error Occured while deleting user";

		}

		return result;

	}
	
	public String fetchUserByUserName(String userName){
		
		return repo.findUserByName(userName);
		
			
	}
}
