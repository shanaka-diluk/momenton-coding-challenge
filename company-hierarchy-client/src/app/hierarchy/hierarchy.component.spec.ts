import { async, ComponentFixture, TestBed, tick,  fakeAsync} from '@angular/core/testing';
import { HierarchyService } from '../services/hierarchy.service';
import { HierarchyComponent } from './hierarchy.component';
import { HierarchyItemComponent } from './hierarchy-item/hierarchy-item.component';
import { Observable, of } from 'rxjs'
import { HierarchyView } from '../models/hierarchy-view.model'


describe('HierarchyComponent', () => {
  let component: HierarchyComponent;
  let fixture: ComponentFixture<HierarchyComponent>;
  let mockHierarchyService: HierarchyService;

  class MockHierarchyService {
    public getFullHierarchy() : Observable<HierarchyView[]>  {
      return of([{"name":"Jamie","subHierarchy":[{"name":"Alan","subHierarchy":[{"name":"Martin", "subHierarchy":[]},{"name":"Alex", "subHierarchy":[]}]},{"name":"Steve","subHierarchy":[{"name":"David", "subHierarchy":[]}]}]}])
    }

    public getHierarchy(empId:number) : Observable<HierarchyView> {

      return of({"name" :"Steve","subHierarchy": [{"name":"David", "subHierarchy":[]}]});
    }
  }

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ HierarchyComponent, HierarchyItemComponent],
      providers: [HierarchyComponent, {provide : HierarchyService, useClass: MockHierarchyService}]
    }).compileComponents()

    fixture = TestBed.createComponent(HierarchyComponent);
    component = TestBed.get(HierarchyComponent);
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
    mockHierarchyService.getHierarchy(100).subscribe((input) => {      
      expect(input.name).toBe('Steve');
      expect(input.subHierarchy.length).toBe(1);
    });
  });

  it('should have hierarchy initalized after init',  () => {
    component.ngOnInit();
    fixture.detectChanges();
    expect(component.hierarchyView).toBeTruthy();
  });

});
