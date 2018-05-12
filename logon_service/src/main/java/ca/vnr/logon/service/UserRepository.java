package ca.vnr.logon.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.vnr.logon.domain.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository <User, Long>  {

	List<User> findAll();

	Page<User> findByUserNameContainingIgnoringCase(String uname, Pageable pageable);
	
	User findByUserNameAllIgnoringCase(String uname);
	
}
