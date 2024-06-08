package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Response;
import com.example.demo.services.NewsService;


@RestController
@RequestMapping("newsapi/")
public class NewsController {
		
		@GetMapping(value = "Categorizednews/{category}")
		public Response sendCategorizedNews( @PathVariable String category) {
			return NewsService.searchByCategory(category);
		} 
		
		@GetMapping(value = "PublishedDate/{startDate}/{endDate}")
		public Response searchByDate(@PathVariable String startDate, @PathVariable String endDate) {
			return NewsService.searchByDate(startDate, endDate);
		}

}
