package com.challenge.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=50)
	@Email
	private String username;
	
	@NotBlank
	@Size(max=120)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {}

	public User(@NotBlank @Size(max = 50) @Email String username, @NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(@NotBlank @Size(max = 50) @Email String username, @NotBlank @Size(max = 120) String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.roles.add(role);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
}
