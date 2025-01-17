package com.example.demo.models;

import java.util.List;

public class Response {

	private String status;
	private int totalResults;
	private List<Article> articles;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public Response() {
	}
	

	public Response(String status, int totalResults, List<Article> articles) {
		super();
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	


}
