package ca.vnr.logon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.*;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.beans.factory.annotation.Autowired;
import ca.vnr.logon.domain.User;
import ca.vnr.logon.service.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


@SpringBootApplication(exclude = SessionAutoConfiguration.class)
@EnableCaching


public class LogonApplication implements CommandLineRunner {

	  private final Logger LOG = LoggerFactory.getLogger(getClass());
	  private final UserRepository userRepository;
	  private static final AtomicLong counter = new AtomicLong();

	  @Autowired
	  public LogonApplication(UserRepository userRepository) {
	    this.userRepository = userRepository;
	  }

	  public static void main(String[] args) {
	    SpringApplication.run(LogonApplication.class, args);
	  }

	  @Override
	  public void run(String... strings) {
	    //Populating embedded database here
	    LOG.info("Saving users. Current user count is {}.", userRepository.count());
	    User admin = new User(counter.incrementAndGet(),"admin", "admin_pass");
	    User user1 = new User(counter.incrementAndGet(),"user1", "pass1");
	    User user2 = new User(counter.incrementAndGet(),"user2", "pass2");

	    userRepository.save(admin);
	    userRepository.save(user1);
	    userRepository.save(user2);
	    LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	  }
	}