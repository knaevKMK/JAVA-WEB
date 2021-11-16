import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'usr/signin', component: AllListingsComponent },
  { path: 'usr/register', component: AllListingsComponent },
  { path: 'usr/profile/:user', component: AllListingsComponent },
  { path: 'usr/accountsettings', component: AllListingsComponent },

  { path: 'help', component: AllListingsComponent },

  { path: 'listings', component: AllListingsComponent },
  { path: 'item/:id', component: AllListingsComponent },
  { path: 'sell', component: AllListingsComponent },
  { path: 'mySellAccount', component: AllListingsComponent },
  { path: 'shoppings', component: AllListingsComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
