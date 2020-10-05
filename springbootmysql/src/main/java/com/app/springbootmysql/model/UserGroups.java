package com.app.springbootmysql.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class UserGroups{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2674000137522645462L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userGroupId;
	private String userGroupName;
	
	public UserGroups(Integer userGroupId, String userGroupName) {
		super();
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
	}

	
	public Integer getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public UserGroups(){
		
	}
	
	
	
}
