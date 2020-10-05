package com.app.springbootmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.springbootmysql.model.UserGroups;
import com.app.springbootmysql.model.Users;

public interface UserGroupAdministrationRepository extends JpaRepository<UserGroups, Integer>{
	
	
}
