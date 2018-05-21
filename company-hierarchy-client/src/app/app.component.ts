import { Component, OnInit } from '@angular/core';
import { HierarchyService } from './services/hierarchy.service';
import { HierarchyView } from './models/hierarchy-view.model'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

	hierarchyView: HierarchyView[];
	
	//hierarchy = '[{"name":"Jamie","subHierarchy":[{"name":"Alan","subHierarchy":[{"name":"Martin"},{"name":"Alex"}]},{"name":"Steve","subHierarchy":[{"name":"David"}]}]}]';
  	
  	title = 'app';

	constructor(private hierarchyService: HierarchyService) {
	}

	ngOnInit() {
	    this.hierarchyService.getFullHierarchy()
	      .subscribe( (data: HierarchyView[]) => {
	        this.hierarchyView = data;
	      });
	  };
}
