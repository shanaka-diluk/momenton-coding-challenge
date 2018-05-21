package com.momenton.codechallenge.companyhierarchy.utils;

import java.util.ArrayList;
import java.util.List;

import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.model.EmployeeType;

public class TestModelProducer {

    public static List<Employee> constructTopModel() {
	
	List<Employee> list = new ArrayList<>();
	
	Employee ceo = new Employee("Robert William", EmployeeType.CEO);
	Employee cto = new Employee("David Miller", EmployeeType.MANAGER);
	cto.addToTeam(new Employee("John Citizen", EmployeeType.MANAGER));
	
	ceo.addToTeam(cto);
	ceo.addToTeam(new Employee("Mark Weber", EmployeeType.MANAGER));
	
	list.add(ceo);
	return list;
    }
    
    public static List<Employee> constructTopModelWithMulti() {
	
	List<Employee> list = constructTopModel();
	/**
	 * coo does not have a manager, regarded as a top level
	 */
	Employee coo = new Employee("COO", EmployeeType.MANAGER);
	coo.addToTeam(new Employee("Tom Jones", EmployeeType.NORMAL));
	list.add(coo);
	
	return list;
    }

}
