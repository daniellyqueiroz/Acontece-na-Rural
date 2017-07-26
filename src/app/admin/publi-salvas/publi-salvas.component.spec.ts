import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PubliSalvasComponent } from './publi-salvas.component';

describe('PubliSalvasComponent', () => {
  let component: PubliSalvasComponent;
  let fixture: ComponentFixture<PubliSalvasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PubliSalvasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PubliSalvasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
