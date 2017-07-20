import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoticiasOficiaisComponent } from './noticias-oficiais.component';

describe('NoticiasOficiaisComponent', () => {
  let component: NoticiasOficiaisComponent;
  let fixture: ComponentFixture<NoticiasOficiaisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoticiasOficiaisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoticiasOficiaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
