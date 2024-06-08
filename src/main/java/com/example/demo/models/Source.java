package com.example.demo.models;

public class Source {
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Source() {
	}

	public Source(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
}
