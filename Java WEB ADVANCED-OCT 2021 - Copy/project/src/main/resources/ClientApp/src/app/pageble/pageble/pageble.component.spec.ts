import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagebleComponent } from './pageble.component';

describe('PagebleComponent', () => {
  let component: PagebleComponent;
  let fixture: ComponentFixture<PagebleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagebleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PagebleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
