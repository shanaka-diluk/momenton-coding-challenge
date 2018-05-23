import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HierarchyItemComponent } from './hierarchy-item.component';

describe('HierarchyItemComponent', () => {
  let component: HierarchyItemComponent;
  let fixture: ComponentFixture<HierarchyItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ HierarchyItemComponent ]
    })
    fixture = TestBed.createComponent(HierarchyItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should show view item', () => {
    component.viewItem = {"name":"John Citizen", "subHierarchy":[]};
    expect(fixture.nativeElement.querySelector('span').textContent).toEqual('John Citizen');
  });
});
