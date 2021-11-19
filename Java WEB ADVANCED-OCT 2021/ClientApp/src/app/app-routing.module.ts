import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';
import { CreateListingComponent } from './listings/create-listing/create-listing.component';
import { DetailsListingComponent } from './listings/details-listing/details-listing.component';
import { ProfileComponent } from './usr/profile/profile.component';
import { RegisterComponent } from './usr/register/register.component';
import { SettingsComponent } from './usr/settings/settings.component';
import { SiginComponent } from './usr/sigin/sigin.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'usr/signin', component: SiginComponent },
  { path: 'usr/register', component: RegisterComponent },
  { path: 'usr/profile/:user', component: ProfileComponent },
  { path: 'usr/accountsettings', component: SettingsComponent },

  { path: 'help', component: AllListingsComponent },

  { path: 'listings', component: AllListingsComponent },
  { path: 'item/:id', component: DetailsListingComponent },
  { path: 'sell', component: CreateListingComponent },
  { path: 'edit/:id', component: CreateListingComponent },
  { path: 'mySellAccount', component: AllListingsComponent },
  { path: 'shoppings', component: AllListingsComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
