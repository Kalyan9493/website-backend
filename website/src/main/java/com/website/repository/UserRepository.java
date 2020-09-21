package com.website.repository;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.website.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	@Query("select e from user e where e.username= ?1 and e.password = ?2")
	User findByUsernameAndPassword(@QueryParam("username")String username,@QueryParam("password")String password);

}
