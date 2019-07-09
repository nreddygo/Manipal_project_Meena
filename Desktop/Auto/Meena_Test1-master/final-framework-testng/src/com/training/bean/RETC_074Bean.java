package com.training.bean;

public class RETC_074Bean {
	
	private String username;
	private String password;
	private String new_role;
	private String message;

	public RETC_074Bean() {
	}

	public RETC_074Bean(String username, String password, String new_role, String message) {
		super();
		this.username = username;
		this.password = password;
		this.new_role = new_role;
		this.message = message;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getnew_role() {
		return new_role;
	}

	public void setnewRole(String new_role) {
		this.new_role = new_role;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "RealEstateBean [username=" + username + ", password=" + password + ", new_role=" + new_role + ", message=" + message + "]";
	}


}
