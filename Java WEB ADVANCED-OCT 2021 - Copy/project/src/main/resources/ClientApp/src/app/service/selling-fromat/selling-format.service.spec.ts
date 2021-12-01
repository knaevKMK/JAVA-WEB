import { TestBed } from '@angular/core/testing';

import { SellingFormatService } from './selling-format.service';

describe('SellingFormatService', () => {
  let service: SellingFormatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SellingFormatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
