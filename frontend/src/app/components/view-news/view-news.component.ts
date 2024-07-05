import { Component, Input } from '@angular/core';
import { Article } from 'src/app/models/article.model';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-view-news',
  templateUrl: './view-news.component.html',
  styleUrls: ['./view-news.component.css']
})
export class ViewNewsComponent{

  // @Input()
  // selectedArticle: Article = new Article;

  selectedArticle: Article = new Article;

  constructor(private router:Router,private route:ActivatedRoute){}

  ngOnInit(){
    var data = this.route.params.subscribe(params => {
      console.log(params)
      this.selectedArticle = params
    
    });
    console.log('Data from get page for edit :: ',this.selectedArticle.title);
    
  }
  
    formatDate(){

    }
}

