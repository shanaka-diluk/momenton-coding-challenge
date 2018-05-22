import { async, ComponentFixture, TestBed, tick,  fakeAsync } from '@angular/core/testing';
import { HierarchyService } from '../services/hierarchy.service';
import { HierarchyComponent } from './hierarchy.component';
import { HierarchyItemComponent } from './hierarchy-item/hierarchy-item.component';
import { Observable } from 'rxjs';

describe('HierarchyComponent', () => {
  let component: HierarchyComponent;
  let fixture: ComponentFixture<HierarchyComponent>;
  let mockHierarchyService: HierarchyService;

  class MockHierarchyService {
    public getFullHierarchy() {
      return {subscribe:() => {
        [{"name":"Jamie","subHierarchy":[{"name":"Alan","subHierarchy":[{"name":"Martin"},{"name":"Alex"}]},{"name":"Steve","subHierarchy":[{"name":"David"}]}]}];
      }};
    }

    public getHierarchy(empId) {
      return {subscribe:() => {
        {"name":"Steve", "subHierarchy": [{"name":"David"}]};
      }};
    }
  }

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ HierarchyComponent, HierarchyItemComponent],
      providers: [HierarchyComponent, {provide : HierarchyService, useClass: MockHierarchyService}]
    })

    fixture = TestBed.createComponent(HierarchyComponent);
    component = TestBed.get(HierarchyComponent);//fixture.componentInstance;
    mockHierarchyService = TestBed.get(HierarchyService);
    //fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeDefined();
  });

  it('should not have hierarchy initalized after construction', () => {
    expect(component.hierarchyView).toBeUndefined();
  });

  it('should return full hierarchy from mock service', () => {
    mockHierarchyService.getFullHierarchy().subscribe((data) => {
      expect(data.length).toBe(1);
      expect(data[0].name).toBe('Jamie');
      expect(data[0].subHierarchy.length).toBe(2);
    });
  });

  it('should return hierarchy for manager from mock service', () => {
    mockHierarchyService.getHierarchy(1).subscribe((data) => {
      expect(data.name).toBe('Steve');
      expect(data.subHierarchy.length).toBe(1);
    });
  });

  it('should have hierarchy initalized after init',  () => {
    component.ngOnInit();
    //tick();
    console.log(component.hierarchyView);
    expect(component.hierarchyView).toBeTruthy();
  });

});
