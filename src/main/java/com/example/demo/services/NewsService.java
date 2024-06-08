package com.example.demo.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Article;
import com.example.demo.models.Response;
import com.example.demo.models.Source;

@Service
public class NewsService {
	
	
	//@Value("${api-key}")
	private static String apiKey = "c9293c8486d745a8a275a3cf4958ea19";
	
	private static NewsService ourInstance = new NewsService();

	public static NewsService getInstance() {
	        return ourInstance;
	    }
	
	static RestTemplate restTemplate = new RestTemplate();
	static JSONObject root; 
	
	public static Response searchByCategory(String category)  throws ParseException, IOException{
		
		//System.out.println(apiKey);
		
		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=" + apiKey +
				 "&category=" +category;
		
 	    String result = restTemplate.getForObject(urlString, String.class);	    	
 		    	  root= new JSONObject(result);   
 		    	  
    	 List<Article> newsList = new ArrayList<>();
    	 	String id=null;
    	    String status = null;
    	    Integer totalResults = null;
    	    String name = null;                
    	    String author = null;         		
    		String title = null;
    		String description = null;
    		String url = null;
    		String urlToImage = null;
    		String publishedAt = null;
    		String content = null;
    		
			status =  root.getString("status");
			totalResults =  root.getInt("totalResults");
			
			 Response response = new Response();
			 JSONArray articlesObject = root.getJSONArray("articles");
			 //System.out.println(articlesObject.length());
			 if(status.equals("ok")) {
				 for(int i = 0; i < articlesObject.length(); i++)
				  {
					 JSONObject arrayElement = articlesObject.getJSONObject(i);
					 JSONObject sourceother = arrayElement.getJSONObject("source");
					 
					id= sourceother.isNull("id") ? null : sourceother.getString("id"); 
					name = sourceother.isNull("name") ? null : sourceother.getString("name");
					title =  arrayElement.isNull("title") ? null : arrayElement.getString("title");
					author =  arrayElement.isNull("author") ? null : arrayElement.getString("author");
					description =  arrayElement.isNull("description") ? null : arrayElement.getString("description");
					url =  arrayElement.isNull("url") ? null : arrayElement.getString("url");
				    urlToImage =  arrayElement.isNull("urlToImage") ? null : arrayElement.getString("urlToImage");
					publishedAt =  arrayElement.isNull("publishedAt") ? null : arrayElement.getString("publishedAt");
					content =  arrayElement.isNull("content") ? null : arrayElement.getString("content");
					
					Article a = new Article();
					Source source = new Source(id, name);
					
					 a.setTitle(title);
					 a.setAuthor(author);
					 a.setDescription(description);
					 a.setUrl(url);
					 a.setUrlToImage(urlToImage);
					 a.setPublishedAt(publishedAt);
					 a.setContent(content);
					 
					 a.setSource(source);
					 newsList.add(a);
					 //System.out.println(a);
					 }
				 
				 
				  response.setStatus(status);
				  response.setTotalResults(totalResults);
				  response.setArticles(newsList);
			 }else {
				 //exception handling
			 }
			 
			  
			  return response;
	}
	
	public static Response searchByDate(String startDate, String endDate)  throws ParseException, IOException{
		
		String urlString = "https://newsapi.org/v2/everything?q=a&from" + startDate +
				 "&to=" +endDate + "&apiKey=" +apiKey;
		
	    String result = restTemplate.getForObject(urlString, String.class);	    	
		    	  root= new JSONObject(result);   
		    	  
   	 List<Article> newsList = new ArrayList<>();
   	 	String id=null;
   	    String status = null;
   	    Integer totalResults = null;
   	    String name = null;                
   	    String author = null;         		
   		String title = null;
   		String description = null;
   		String url = null;
   		String urlToImage = null;
   		String publishedAt = null;
   		String content = null;
   		
			status =  root.getString("status");
			totalResults =  root.getInt("totalResults");
			
			 Response response = new Response();
			 JSONArray articlesObject = root.getJSONArray("articles");
			 //System.out.println(articlesObject.length());
			 if(status.equals("ok")) {
				 for(int i = 0; i < articlesObject.length(); i++)
				  {
					 JSONObject arrayElement = articlesObject.getJSONObject(i);
					 JSONObject sourceother = arrayElement.getJSONObject("source");
					 
					id= sourceother.isNull("id") ? null : sourceother.getString("id"); 
					name = sourceother.isNull("name") ? null : sourceother.getString("name");
					title =  arrayElement.isNull("title") ? null : arrayElement.getString("title");
					author =  arrayElement.isNull("author") ? null : arrayElement.getString("author");
					description =  arrayElement.isNull("description") ? null : arrayElement.getString("description");
					url =  arrayElement.isNull("url") ? null : arrayElement.getString("url");
				    urlToImage =  arrayElement.isNull("urlToImage") ? null : arrayElement.getString("urlToImage");
					publishedAt =  arrayElement.isNull("publishedAt") ? null : arrayElement.getString("publishedAt");
					content =  arrayElement.isNull("content") ? null : arrayElement.getString("content");
					
					Article a = new Article();
					Source source = new Source(id, name);
					
					 a.setTitle(title);
					 a.setAuthor(author);
					 a.setDescription(description);
					 a.setUrl(url);
					 a.setUrlToImage(urlToImage);
					 a.setPublishedAt(publishedAt);
					 a.setContent(content);
					 
					 a.setSource(source);
					 newsList.add(a);
					 //System.out.println(a);
					 }
				 
				 
				  response.setStatus(status);
				  response.setTotalResults(totalResults);
				  response.setArticles(newsList);
			 }else {
				 //exception handling
			 }
			 
			  
			  return response;
		
	}
	
	
 		    	  
}
	 
