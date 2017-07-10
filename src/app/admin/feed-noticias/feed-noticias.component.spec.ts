import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedNoticiasComponent } from './feed-noticias.component';

describe('FeedNoticiasComponent', () => {
  let component: FeedNoticiasComponent;
  let fixture: ComponentFixture<FeedNoticiasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeedNoticiasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedNoticiasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
