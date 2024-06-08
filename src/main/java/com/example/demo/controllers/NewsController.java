package com.example.demo.controllers;

import java.io.IOException;
import java.text.ParseException;

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
		public Response sendCategorizedNews( @PathVariable String category) throws ParseException, IOException {
			return NewsService.searchByCategory(category);
		} 
		
		@GetMapping(value = "PublishedDate/{startDate}/{endDate}")
		public Response searchByDate(@PathVariable String startDate, @PathVariable String endDate) throws ParseException, IOException {
			return NewsService.searchByDate(startDate, endDate);
		}

}
