import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryView } from 'src/app/models/category';
import { ConditionView } from 'src/app/models/condition';
import { DeliveryView } from 'src/app/models/delivery';
import { ListingCreateForm } from 'src/app/models/listing';
import { CategoryService } from 'src/app/service/category.service';
import { ConditionService } from 'src/app/service/condition/condition.service';
import { DeliveryService } from 'src/app/service/delivery/delivery.service';
import { ListingService } from 'src/app/service/listing.service';
import { SellingFormatService } from 'src/app/service/selling-fromat/selling-format.service';

@Component({
  selector: 'app-create-listing',
  templateUrl: './create-listing.component.html',
  styleUrls: ['./create-listing.component.css']
})
export class CreateListingComponent implements OnInit {
  createForm: FormGroup;
  categories: CategoryView[] = [];
  conditions: ConditionView[] = []
  sellingFormats: string[] = [];
  deliveryDomestic: DeliveryView[] = [];
  deliveryInternatonal: DeliveryView[] = [];
  id: string;
  isEditMode: boolean = false;
  constructor(private fb: FormBuilder,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private listingService: ListingService,
    private categoryService: CategoryService,
    private conditionService: ConditionService,
    private sellingFormatService: SellingFormatService,
    private deliveryService: DeliveryService
  ) {
    this.createForm = this.fb.group(ListingCreateForm(fb));
    this.id = this.activateRoute.snapshot.params['id'];
    this.categoryService.getAll()
      .subscribe(result => {
        console.log(Object(result)['data']['categories'])
        this.categories = Object(result)['data']['categories']
      });
    this.conditionService.getAll()
      .subscribe(result => {
        console.log(Object(result)['data']['conditions'])
        this.conditions = Object(result)['data']['conditions']
      });

    this.sellingFormatService.getAll()
      .subscribe(result => {
        console.log(Object(result)['data']['selling-formats'])
        this.sellingFormats = Object(result)['data']['selling-formats']
      });
    this.deliveryService.getAll()
      .subscribe(result => {
        console.log(Object(result)['data']['delivery'])
        this.deliveryDomestic = Object(result)['data']['delivery'][0]['deliveryService']
        //  .filter(o => o['deliveryArea'] === "DOMESTIC");
        this.deliveryInternatonal = Object(result)['data']['delivery'][1]['deliveryService']
        // .filter(o => o.deliveryArea === "INTERNATIONAL");
      });

    this.isEditMode = this.id != undefined && this.id.length > 0;
    this.isEditMode
      ? this.listingService.getById(this.id)
        .subscribe(result => {
          console.log(Object(result)['data']['listing'])
          this.createForm.setValue(Object(result)['data']['listing']);
          console.log(this.createForm.value)
        })
      : this.createForm = this.fb.group(ListingCreateForm(fb));
  }

  ngOnInit(): void {
    this.id = this.activateRoute.snapshot.params['id'];

  }
  onCreate() {
    console.log(this.createForm.value)
    !this.isEditMode
      ? this.listingService.create(this.createForm.value)
        .subscribe(result => {
          console.log(result)
          this.router.navigate(['/item/' + Object(result)['data']['id']]);
        })
      : this.listingService.update(this.id, this.createForm.value)
        .subscribe(result => {
          console.log(result)
          this.router.navigate(['/item/' + Object(result)['data']['id']]);
        });
  }

  onBack() {
    this.router.navigate([".."]);
  }
  onClear() {
    this.createForm.reset();
  }
}
