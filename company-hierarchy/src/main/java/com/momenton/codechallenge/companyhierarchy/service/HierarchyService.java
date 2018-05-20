package com.momenton.codechallenge.companyhierarchy.service;

import java.util.List;

import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

/**
 * interface defining company hierarchy related services
 *
 */
public interface HierarchyService {

    /**
     * retrieves the organisation hierarchy from the highest level. Is is assumed
     * that each employee has a manager and only the top level employees do not have
     * such.
     * 
     * @return <code>HierarchyView</code> hierarchy view
     */
    List<HierarchyView> getHierarchy();

    /**
     * retrieves the organisation hierarchy
     * 
     * @param empId
     *            - id of the top level employee of the hierarchy
     * @return <code>HierarchyView</code> hierarchy view.
     * 
     * @throws <code>HierarchyException</code>
     */
    HierarchyView getHierarchy(Integer empId) throws HierarchyException;

}
