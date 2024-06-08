package com.example.demo.models;

public class Error {
	
	private String status;
	private String code;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error() {
		// TODO Auto-generated constructor stub
	}

	public Error(String status, String code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	

}
