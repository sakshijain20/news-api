import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewNewsComponent } from './components/view-news/view-news.component';
import { HomePageComponent } from './components/home-page/home-page.component';

const routes: Routes = [

  {
    path: 'home',
    component: HomePageComponent,
  },
  {
    path: 'view-news',
    component: ViewNewsComponent,
  },
 
  { path: '**', redirectTo: 'home', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
