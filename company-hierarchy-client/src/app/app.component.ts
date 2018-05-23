import { Component, OnInit } from '@angular/core';
import { HierarchyService } from './services/hierarchy.service';
import { HierarchyView } from './models/hierarchy-view.model'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  	title = 'Acme Organisation Hierarchy';

	constructor(private hierarchyService: HierarchyService) {
	}

	ngOnInit() {
	}
}
