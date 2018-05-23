import { Component, OnInit, Input } from '@angular/core';
import { HierarchyView } from '../../models/hierarchy-view.model'

@Component({
  selector: 'app-hierarchy-item',
  templateUrl: './hierarchy-item.component.html',
  styleUrls: ['./hierarchy-item.component.css']
})
export class HierarchyItemComponent implements OnInit {

	@Input() viewItem: HierarchyView;
  
  constructor() { }

  ngOnInit() {
  }

}
