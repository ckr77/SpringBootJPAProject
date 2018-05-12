package ca.vnr.logon.service;

import ca.vnr.logon.domain.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	Page<User> findUsers(UserSearchCriteria criteria, Pageable pageable);
	
	List<User> findAllUsers();

	User getUser(String name);
}
