package com.cts.newsarticle.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull(message = "Username cannot be null")
	@Column(name = "us_name")
	@Size(max = 50, message = "Name must not exceed 50 characters")
	private String name;

	@NotNull(message = "Email cannot be null")
	@Column(name = "us_email")
	@Size(max = 255, message = "Email must not exceed 255 characters")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	private String email;

	@Column(name = "us_status")
	private boolean status;

	@NotNull(message = "Password cannot be null")
	@Size(min = 6, max = 50, message = "Password must be 6 to 50 characters")
	@Column(name = "us_password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_ur_id")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_la_id")
	private Language language;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favourite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fa_ar_id") })
	private List<Article> article;

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + ", password="
				+ password + ", role=" + role + ", language=" + language + ", article=" + article + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, @NotNull(message = "Username cannot be null") String name,
			@NotNull(message = "Email cannot be null") String email, boolean status, String password, Role role,
			Language language, List<Article> article) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
		this.password = password;
		this.role = role;
		this.language = language;
		this.article = article;
	}

}
