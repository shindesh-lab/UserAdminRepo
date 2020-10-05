package com.app.springbootmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.springbootmysql.model.Users;

public interface UserAdministrationRepository extends JpaRepository<Users, Integer>{
	
	public Users findByEmailId(String emailId);
	
	public static final String FIND_USER = "";

	
	public Users findUserByUserNameAndPassword(String userName,String password);
	@Transactional
	@Modifying
	@Query("update Users c set c.is_lock = :is_lock WHERE c.userId = :userId")
    void setCustomerName(@Param("userId") int id,@Param("is_lock") String lock);

	@Transactional
	@Query("SELECT c.is_lock FROM Users c WHERE c.userName = :userName")
	public String findLockUserByName(@Param("userName") String name);
	
	@Transactional
	@Query("SELECT c.userName FROM Users c WHERE c.userName = :userName")
	public String findUserByName(@Param("userName") String name);

}
