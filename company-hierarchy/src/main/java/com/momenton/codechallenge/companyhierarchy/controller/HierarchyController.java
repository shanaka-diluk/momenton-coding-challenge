package com.momenton.codechallenge.companyhierarchy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.momenton.codechallenge.companyhierarchy.exception.EmployeeNotFoundException;
import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.service.HierarchyService;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HierarchyController {

    @Resource(name = "HierarchyServiceImpl")
    HierarchyService hierarchyService;

    /**
     * retrieves the hierarchy from top level
     * 
     * @return List of top level hierarchies
     */
    @GetMapping(path = "/hierarchy", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<HierarchyView> getFullHierarchy() {

	return hierarchyService.getHierarchy();

    }

    /**
     * retrieves the hierarchy from the given employee id
     * 
     * @param empId
     *            - employee id
     * 
     * @return <code>HierarchyView</code> object relates to the employee id.
     */
    @GetMapping(path = "/hierarchy/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
    public HierarchyView getHierarchyForManager(@PathVariable("id") Integer empId) {

	try {

	    return hierarchyService.getHierarchy(empId);

	} catch (HierarchyException e) {
	    throw new EmployeeNotFoundException(String.format("[Id - %1$d]", empId));
	}

    }

}
