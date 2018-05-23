import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HierarchyView } from '../models/hierarchy-view.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class HierarchyService {

	private urlPath = '/api/hierarchy';

	constructor(private httpClient:HttpClient) {
	}
	
	public getFullHierarchy() {
		return this.httpClient.get<HierarchyView[]>(this.urlPath);
	}
	
	public getHierarchy(empId) {
		return this.httpClient.get<HierarchyView[]>(this.urlPath +'/'+empId);
	}
	
}