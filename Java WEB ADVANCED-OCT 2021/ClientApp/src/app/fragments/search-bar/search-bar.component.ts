import { query } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styles: [
  ]
})
export class SearchBarComponent implements OnInit {
  searchForm: FormGroup;
  constructor(private fb: FormBuilder,
    private router: Router) {

    this.searchForm = fb.group({
      search: [null, Validators.required]
    });
  }

  ngOnInit(): void {
  }
  onSearch() {
    console.log(this.searchForm.value)
    let searchInput: string = this.searchForm.value['search'];
    if (searchInput === null || searchInput.trim() === '') {
      console.log(searchInput)
      return;
    }
    console.log(this.searchForm.value)
    this.router.navigate(['listing/all'], { queryParams: this.searchForm.value });
  }
}
