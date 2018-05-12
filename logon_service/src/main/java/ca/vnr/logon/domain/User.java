package ca.vnr.logon.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", initialValue = 1)
	@GeneratedValue(generator = "user_generator")
	private Long id;

	@Column(nullable = true)
	private String firstName;

	@Column(nullable = true)
	private String lastName;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private String email;

	protected User() {
	}

	public User(long id, String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return getUserName() + "," + getFirstName() + "," + getLastName();
	}

}

