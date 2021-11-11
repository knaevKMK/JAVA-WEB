import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';

const routes: Routes = [
  { path: '', component: AllListingsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
