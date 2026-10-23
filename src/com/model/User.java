package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String passwordHash;

	@Column(unique = true, nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role = Role.CUSTOMER;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Accountdetails> accountdetails = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Accountdetails> getAccountdetails() {
		return accountdetails;
	}

	public void setAccountdetails(List<Accountdetails> accountdetails) {
		this.accountdetails = accountdetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + "]";
	}

}
