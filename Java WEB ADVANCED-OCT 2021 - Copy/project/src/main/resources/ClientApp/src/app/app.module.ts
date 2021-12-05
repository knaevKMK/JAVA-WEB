import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';
import { CreateListingComponent } from './listings/create-listing/create-listing.component';
import { DetailsListingComponent } from './listings/details-listing/details-listing.component';
import { NavBarComponent } from './fragments/nav-bar/nav-bar/nav-bar.component';
import { FooterComponent } from './fragments/footer/footer/footer.component';
import { SearchBarComponent } from './fragments/search-bar/search-bar.component';
import { HomeComponent } from './home/home.component';
import { SiginComponent } from './usr/sigin/sigin.component';
import { RegisterComponent } from './usr/register/register.component';
import { ProfileComponent } from './usr/profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OrderConfirmComponent } from './order/order-confirm/order-confirm.component';
import { OrderListComponent } from './order/order-list/order-list.component';
import { OrderSoldsComponent } from './order/order-solds/order-solds.component';
import { BasketComponent } from './order/basket/basket.component';
import { MsgsComponent } from './usr/msgs/msgs.component';
import { FeedbackComponent } from './feedback/feedback/feedback.component';
import { FeedbackCreateComponent } from './feedback/feedback-create/feedback-create.component';
import { HelpComponent } from './support/help/help.component';
import { CarouselComponent } from './home/fragmets/carousel/carousel.component';
import { MsgFormComponent } from './fragments/msg-form/msg-form/msg-form.component';
import { FeedbackFormComponent } from './fragments/feedback/feedback-form/feedback-form.component';
import { FeedbackListComponent } from './fragments/feedback/feedback-list/feedback-list.component';
import { PagebleComponent } from './pageble/pageble/pageble.component';

@NgModule({
  declarations: [
    AppComponent,
    AllListingsComponent,
    CreateListingComponent,
    DetailsListingComponent,
    NavBarComponent,
    FooterComponent,
    SearchBarComponent,
    HomeComponent,
    SiginComponent,
    RegisterComponent,
    ProfileComponent,
    OrderConfirmComponent,
    OrderListComponent,
    OrderSoldsComponent,
    BasketComponent,
    MsgsComponent,
    FeedbackComponent,
    FeedbackCreateComponent,
    HelpComponent,
    CarouselComponent,
    MsgFormComponent,
    FeedbackFormComponent,
    FeedbackListComponent,
    PagebleComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
