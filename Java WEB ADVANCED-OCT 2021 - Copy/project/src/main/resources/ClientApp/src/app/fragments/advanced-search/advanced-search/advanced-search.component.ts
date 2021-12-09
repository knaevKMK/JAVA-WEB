import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryView } from 'src/app/models/category';
import { ConditionView } from 'src/app/models/condition';
import { ApiResponse } from 'src/app/models/response';
import { SearchForm, SearchResult } from 'src/app/models/searc';
import { CategoryService } from 'src/app/service/category.service';
import { ConditionService } from 'src/app/service/condition/condition.service';
import { SellingFormatService } from 'src/app/service/selling-fromat/selling-format.service';

@Component({
  selector: 'app-advanced-search',
  templateUrl: './advanced-search.component.html',
  styles: [
  ]
})
export class AdvancedSearchComponent implements OnInit {
  public filterForm: FormGroup;
  categories: CategoryView[] = [];
  conditions: ConditionView[] = []
  sellingFormats: string[] = [];

  constructor(
    private categoryService: CategoryService,
    private conditionService: ConditionService,
    private sellingFormatService: SellingFormatService,
    private router: Router,
    private fb: FormBuilder,
  ) {
    this.filterForm = this.fb.group(SearchForm());
    this.categoryService.getAll()
      .subscribe(result => {
        this.categories = ApiResponse(result).getCategories;
      });
    this.conditionService.getAll()
      .subscribe(result => {
        this.conditions = ApiResponse(result).getConditions;
      });

    this.sellingFormatService.getAll()
      .subscribe(result => {
        this.sellingFormats = ApiResponse(result).getSellingFormat;
      });
  }

  ngOnInit(): void { }

  onClear() {
    this.filterForm.reset;
  }
  onFilter() {
    console.log(this.filterForm.value)
    var query = SearchResult(this.filterForm.value);
    console.log(query)
    this.router.navigate(['/listing/all'], { queryParams: { "query": "advsearch " + JSON.stringify(query) } });
  }

  get title() { return this.filterForm.get('title') }
  get titleSort() { return this.filterForm.get('titleSort') }
  get description() { return this.filterForm.get('description') }
  get category() { return this.filterForm.get('category') }
  get condition() { return this.filterForm.get('condition') }
  get seller() { return this.filterForm.get('seller') }
  get sellingFormat() { return this.filterForm.get('sellingFormat') }
  get price() { return this.filterForm.get('price') }
  get priceSort() { return this.filterForm.get('priceSort') }
  get priceArrow() { return this.filterForm.get('priceArrow') }
  get timeSort() { return this.filterForm.get('timeSort') }
}
