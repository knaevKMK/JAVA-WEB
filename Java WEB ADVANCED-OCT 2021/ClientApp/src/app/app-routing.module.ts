import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationGuard } from './authentication.guard';
import { HomeComponent } from './home/home.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';
import { CreateListingComponent } from './listings/create-listing/create-listing.component';
import { DetailsListingComponent } from './listings/details-listing/details-listing.component';
import { OrderConfirmComponent } from './order/order-confirm/order-confirm.component';
import { ProfileComponent } from './usr/profile/profile.component';
import { RegisterComponent } from './usr/register/register.component';
import { SettingsComponent } from './usr/settings/settings.component';
import { SiginComponent } from './usr/sigin/sigin.component';

const routes: Routes = [
  { path: '', component: HomeComponent },

  {
    path: 'usr', children: [
      { path: 'signin', component: SiginComponent },
      { path: 'register', component: RegisterComponent },

      { path: 'profile/:username', component: ProfileComponent, canActivate: [AuthenticationGuard] },
      { path: 'accountsettings', component: SettingsComponent, canActivate: [AuthenticationGuard] },
      { path: 'mySellAccount', component: AllListingsComponent, canActivate: [AuthenticationGuard] },
    ]
  },
  { path: 'help', component: AllListingsComponent },


  {
    path: 'listing', children: [
      { path: 'all', component: AllListingsComponent },
      { path: 'sell', component: CreateListingComponent, canActivate: [AuthenticationGuard] },
      { path: 'item/:id', component: DetailsListingComponent },
      { path: 'edit/:id', component: CreateListingComponent, canActivate: [AuthenticationGuard] },
    ]
  },

  { path: 'shoppings', component: AllListingsComponent, canActivate: [AuthenticationGuard] },
  {
    path: 'orders', children: [
      { path: 'order/:id', component: OrderConfirmComponent, canActivate: [AuthenticationGuard] },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
