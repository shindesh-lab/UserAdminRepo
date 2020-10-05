package com.app.springbootmysql.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class Users{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2674000137522645462L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String password;
	private String emailId;
	private String is_lock;
	
	@ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "userGroupId", nullable = false)
	private UserGroups userGroups;
	
	
	public UserGroups getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(UserGroups userGroups) {
		this.userGroups = userGroups;
	}
	public String getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(String is_lock) {
		this.is_lock = is_lock;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Users(Integer userId, String userName, String password, String emailId,String is_lock) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.is_lock = is_lock;
	}
	
	
	public Users(){
		
	}
	
	
	
}
