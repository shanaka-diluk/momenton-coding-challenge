import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HierarchyComponent } from './hierarchy/hierarchy.component';
import { HierarchyItemComponent } from './hierarchy/hierarchy-item/hierarchy-item.component';
import { HierarchyService } from './services/hierarchy.service';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HierarchyComponent,
    HierarchyItemComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HierarchyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
