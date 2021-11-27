import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderSoldsComponent } from './order-solds.component';

describe('OrderSoldsComponent', () => {
  let component: OrderSoldsComponent;
  let fixture: ComponentFixture<OrderSoldsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderSoldsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderSoldsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
