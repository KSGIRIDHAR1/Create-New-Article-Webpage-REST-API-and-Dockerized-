package com.cts.newsarticle.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "la_id")
	private int id;

	@Column(name = "la_name")
	private String name;

	@Column(name = "la_code")
	private String code;
	
	
	
	public Language(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

	public Language() {
		super();
	}
	

}
