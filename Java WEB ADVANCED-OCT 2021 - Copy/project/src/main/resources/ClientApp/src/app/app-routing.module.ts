import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationGuard } from './authentication.guard';
import { HomeComponent } from './home/home.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';
import { CreateListingComponent } from './listings/create-listing/create-listing.component';
import { DetailsListingComponent } from './listings/details-listing/details-listing.component';
import { BasketComponent } from './order/basket/basket.component';
import { OrderConfirmComponent } from './order/order-confirm/order-confirm.component';
import { OrderListComponent } from './order/order-list/order-list.component';
import { OrderSoldsComponent } from './order/order-solds/order-solds.component';
import { MsgsComponent } from './usr/msgs/msgs.component';
import { ProfileComponent } from './usr/profile/profile.component';
import { RegisterComponent } from './usr/register/register.component';
import { SiginComponent } from './usr/sigin/sigin.component';
import { HelpComponent } from "./support/help/help.component";

const routes: Routes = [
  { path: '', component: HomeComponent },

  {
    path: 'usr', children: [
      { path: 'signin', component: SiginComponent },
      { path: 'register', component: RegisterComponent },

      { path: 'profile/:username', component: ProfileComponent, canActivate: [AuthenticationGuard] },
      { path: 'msgs', component: MsgsComponent, canActivate: [AuthenticationGuard] },
      { path: 'mySellAccount', component: AllListingsComponent, canActivate: [AuthenticationGuard] },
    ]
  },
  { path: 'help', component: HelpComponent },


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
      { path: 'purchase', component: OrderListComponent, canActivate: [AuthenticationGuard] },
      { path: 'solds', component: OrderSoldsComponent, canActivate: [AuthenticationGuard] },
      { path: 'basket', component: BasketComponent, canActivate: [AuthenticationGuard] },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
