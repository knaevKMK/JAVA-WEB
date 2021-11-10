import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllListingsComponent } from './listings/all-listings/all-listings.component';
import { CreateListingComponent } from './listings/create-listing/create-listing.component';
import { DetailsListingComponent } from './listings/details-listing/details-listing.component';

@NgModule({
  declarations: [
    AppComponent,
    AllListingsComponent,
    CreateListingComponent,
    DetailsListingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
