package com.cts.newsarticle.bean;

import com.cts.newsarticle.bean.SignUpStatus;

public class SignUpStatus {

	private boolean signupStatus;
	private String message;

	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SignUpStatus(boolean signupStatus, String message) {
		super();
		this.signupStatus = signupStatus;
		this.message = message;
	}

	public SignUpStatus() {

	}

	public boolean equals(Object o) {
		SignUpStatus s = (SignUpStatus) o;
		return s.isSignupStatus() == this.signupStatus && this.message.equals(s.getMessage());
	}

}
