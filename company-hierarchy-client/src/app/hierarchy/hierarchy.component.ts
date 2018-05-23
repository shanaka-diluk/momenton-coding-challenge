import { Component, OnInit } from '@angular/core';
import { HierarchyService } from '../services/hierarchy.service';
import { HierarchyView } from '../models/hierarchy-view.model'

@Component({
  selector: 'app-hierarchy',
  templateUrl: './hierarchy.component.html',
  styleUrls: ['./hierarchy.component.css']
})
export class HierarchyComponent implements OnInit {

	hierarchyView: HierarchyView[];
	error;
	
	constructor(private hierarchyService: HierarchyService) {
	}

	ngOnInit() {
	    this.hierarchyService.getFullHierarchy()
	      .subscribe( (data: HierarchyView[]) => {          
	        this.hierarchyView = data;
	      },
	      error => this.error = error
	      );
	}

}
