import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ListingCreateForm } from 'src/app/models/listing';

@Component({
  selector: 'app-create-listing',
  templateUrl: './create-listing.component.html',
  styleUrls: ['./create-listing.component.css']
})
export class CreateListingComponent implements OnInit {
  createForm: FormGroup;

  constructor(private fb: FormBuilder,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {
    this.createForm = this.fb.group(ListingCreateForm(fb));
  }

  ngOnInit(): void {
  }
  onCreate() { console.log(this.createForm.value) }
}
