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

@NgModule({
  declarations: [
    AppComponent,
    AllListingsComponent,
    CreateListingComponent,
    DetailsListingComponent,
    NavBarComponent,
    FooterComponent,
    SearchBarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
