package com.momenton.codechallenge.companyhierarchy.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.repository.EmployeeRepository;
import com.momenton.codechallenge.companyhierarchy.utils.TransformerFactory;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

/**
 * Hierarchy service implementation
 *
 */

@Service("HierarchyServiceImpl")
@Transactional(readOnly = true)
public class HierarchyServiceImpl implements HierarchyService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository repository;

    @Override
    /**
     * @see com.momenton.codechallenge.companyhierarchy.service.HierarchyService#getHierarchy()
     */
    public List<HierarchyView> getHierarchy() {
	return TransformerFactory.transformEmployeeToHierarchy().transorm(repository.findTopLevel());
    }

    @Override
    /**
     * @see com.momenton.codechallenge.companyhierarchy.service.HierarchyService#getHierarchy(java.lang.Integer)
     */
    public HierarchyView getHierarchy(Integer empId) throws HierarchyException {
	Optional<Employee> emp = repository.findById(empId);

	if (!emp.isPresent()) {
	    /**
	     * log the error and pass a generic message to the end user.
	     */
	    LOG.error(String.format("Employee Id[%1$d] not found", empId));
	    throw new HierarchyException("Error retrieving the hierarchy");
	}

	List<HierarchyView> retList = TransformerFactory.transformEmployeeToHierarchy().transorm(Arrays.asList(emp.get()));

	return CollectionUtils.isEmpty(retList) ? null : retList.get(0);

    }

}
