package com.momenton.codechallenge.companyhierarchy.service;

import java.util.List;

import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.model.Employee;

/**
 * interface defining company hierarchy related services
 *
 */
public interface HierarchyService {

    
    /**
     * retrieves the organisation hierarchy from the highest level.
     * Is is assumed that each employee has a manager and only the top level
     * employees do not have such.
     * 
     * @return <code>Employee</code> list with the hierarchy
     */
    List<Employee> getHierarchy();
    
    
    /**
     * retrieves the organisation hierarchy
     * 
     * @param empId - id of the top level employee of the hierarchy
     * @return <code>Employee</code> entity with the hierarchy.
     * 
     * @throws <code>HierarchyException</code>
     */
    Employee getHierarchy(Integer empId) throws HierarchyException;
    
    
}
