import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/article.model';
import { Response } from 'src/app/models/response.model';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  public searchFormGroup!: FormGroup;
  totalNews: any;
  response: Response = new Response();
  public selectedArticle!: Article;

  categories = [
    { id: 1, label: "General" },
    { id: 2, label: "Business" },
    { id: 3, label: "Entertainment"},
    { id: 4, label: "Health"},
    { id: 5, label: "Science"},
    { id: 6, label: "Sports"},
    { id: 7, label: "Technology"}
]


constructor(private httpClient: HttpClient, private form:FormBuilder, private router:Router) { }

get f(){return this.searchFormGroup.controls;}

ngOnInit(){
  this.buildForm();
  
}
buildForm(){
  this.searchFormGroup = this.form.group({
    category: new FormControl(''),
    startDate: new FormControl(''),
    endDate: new FormControl('')
  })
}

checkForParam(event:any){
  
  if(event.value.category){
    console.log('Checking param' +event.value.category)
    this.searchByCategory(event)
  }
  else if(event.value.startDate ){
    if(event.value.endDate){
      this.searchByDate(event.value.startDate, event.value.endDate)
    }else{
      event.value.endDate = new Date()
      let date = JSON.stringify(event.value.endDate)
      date = date.slice(1,11)
      event.value.endDate = date
      this.searchByDate(event.value.startDate, date)
    }
    console.log('Start date:' +event.value.startDate + "\nEnd date:" +event.value.endDate)
    
  }
}

postApiCall(category: any): Observable<Response>{
  console.log('postApiCall api called')
  let url = `http://localhost:8080/newsapi/Categorizednews/${category}`; 
  return this.httpClient.get<Response>(url ,{
    headers:
        new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest',
          }
        )
  })
}

postApiCallByDate(startDate: any, endDate:any): Observable<Response>{
  console.log('postApiCallByDate api called ')
  let url = `http://localhost:8080/newsapi/PublishedDate/${startDate}/${endDate}`; 
  return this.httpClient.get<Response>(url ,{
    headers:
        new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest',
          }
        )
  })
}


searchByCategory(event:any){
    var result = this.postApiCall(event.value.category).subscribe((res ) => {
    this.response = res
    console.log('data from subscribe :: ', this.response)
})
}

searchByDate(startDate: any, endDate: any){
  var result = this.postApiCallByDate(startDate, endDate).subscribe((res ) => {
    this.response = res
    console.log('data from subscribe :: ', this.response)
})
}


// viewClicked(num: Article){
//   this.selectedArticle = num;
//   this.selectedArticle.title = num.title;
//   console.log(this.selectedArticle);
//   //this.router.navigateByUrl('/view-news');
 
// }

}
