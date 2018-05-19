package com.momenton.codechallenge.companyhierarchy.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.repository.EmployeeRepository;

/**
 * Hierarchy service implementation
 *
 */

@Service("HierarchyServiceImpl")
public class HierarchyServiceImpl implements HierarchyService {

    Logger LOG = LoggerFactory.getLogger(getClass());
	    
    @Autowired
    private EmployeeRepository repository;
    
    @Override
    /**
     * @see com.momenton.codechallenge.companyhierarchy.service.HierarchyService#getHierarchy()
     */
    public List<Employee> getHierarchy() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    /**
     * @see com.momenton.codechallenge.companyhierarchy.service.HierarchyService#getHierarchy(java.lang.Integer)
     */
    public Employee getHierarchy(Integer empId) throws HierarchyException {
	Optional<Employee> emp = repository.findById(empId);
	
	if (!emp.isPresent()) {
	    /**
	     * log the error and pass a generic message to the end user.
	     */
	    LOG.error(String.format("Employee Id[%1$d] not found", empId));
	    throw new HierarchyException("Error retrieving the hierarchy");
	}
	
	return emp.get();
    }

}
