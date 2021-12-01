import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryView } from 'src/app/models/category';
import { ConditionView } from 'src/app/models/condition';
import { DeliveryView } from 'src/app/models/delivery';
import { CreateListingErrors, setErrors } from 'src/app/models/errors';
import { ListingCreateForm } from 'src/app/models/listing';
import { responceCategory, responceCondition, responceDeliveryByArea, responceId, responceListing, responceSellingFormat } from 'src/app/models/response';
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
  errors: any = new CreateListingErrors();
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
        this.categories = responceCategory(result);
      });
    this.conditionService.getAll()
      .subscribe(result => {
        this.conditions = responceCondition(result)
      });

    this.sellingFormatService.getAll()
      .subscribe(result => {
        this.sellingFormats = responceSellingFormat(result)
      });
    this.deliveryService.getAll()
      .subscribe(result => {
        this.deliveryDomestic = responceDeliveryByArea(result, 0)
        this.deliveryInternatonal = responceDeliveryByArea(result, 1)
      });

    this.isEditMode = this.id != undefined && this.id.length > 0;
    this.isEditMode
      ? this.listingService.getById(this.id)
        .subscribe(result => {
          console.log(responceListing(result))
          this.createForm.setValue(responceListing(result));

        })
      : this.createForm = this.fb.group(ListingCreateForm(fb));
  }

  ngOnInit(): void {
    this.id = this.activateRoute.snapshot.params['id'];

  }
  onCreate() {
    console.log(this.createForm.value)
    this.errors = new CreateListingErrors();
    var promise = !this.isEditMode
      //create
      ? this.listingService.create(this.createForm.value)
      //update
      : this.listingService.update(this.id, this.createForm.value);

    promise.subscribe(result => {
      this.router.navigate(['/listing/item/' + responceId(result)]);
    }, err => {
      this.errors = setErrors(err, this.errors);
    })
  }

  onBack() {
    this.router.navigate([".."]);
  }
  onClear() {
    this.createForm.reset();
  }


}
