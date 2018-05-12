package ca.vnr.logon.service;

import ca.vnr.logon.domain.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("userService")
@Transactional
class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> findUsers(UserSearchCriteria criteria, Pageable pageable) {

		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();

		if (!StringUtils.hasLength(name)) {
			return this.userRepository.findAll(pageable);
		}
		return this.userRepository
				.findByUserNameContainingIgnoringCase(name.trim(),
						pageable);
	}
	
	@Override
	public User getUser(String name) {
		Assert.notNull(name, "Name must not be null");
		return this.userRepository.findByUserNameAllIgnoringCase(name);
	}
	
	@Override
	public List<User> findAllUsers() {
		return this.userRepository.findAll();
	}

}