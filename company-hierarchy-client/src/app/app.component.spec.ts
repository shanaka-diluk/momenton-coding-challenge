import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { HierarchyComponent } from './hierarchy/hierarchy.component';
import { HierarchyItemComponent } from './hierarchy/hierarchy-item/hierarchy-item.component';
import { HierarchyService } from './services/hierarchy.service';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";

describe('AppComponent', () => {
  let component : AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(() => {

    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HierarchyComponent,
        HierarchyItemComponent
      ],
      providers: [HierarchyService],
      imports: [
        BrowserModule,
        HttpClientModule
      ],
    });

    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
  });

  it('should create the app', () => {
    expect(component).toBeDefined();
  });

  it('should have as title "Acme Organization Hierarchy"', () => {
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Acme Organization Hierarchy');
  });

  it('should render title in a h2 with content component.title', () => {
    fixture.detectChanges();
    const app = fixture.debugElement.componentInstance;
    const ele = fixture.debugElement.nativeElement;
    expect(ele.querySelector('h2').textContent).toContain(app.title);
  });

});
