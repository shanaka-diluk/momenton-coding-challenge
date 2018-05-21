package com.momenton.codechallenge.companyhierarchy.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

/**
 * Factory for view transformers
 *
 */
public class TransformerFactory {

    /**
     * retrieves the implementation of the transformer which converts list of
     * <code>Employee</code> objects to list of <code>HierarchyView</code> objects.
     * 
     * @return
     */
    public static ViewTransformer<List<Employee>, List<HierarchyView>> transformEmployeeToHierarchy() {

	List<HierarchyView> retList = new ArrayList<>();

	return (empList) -> {

	    if (!CollectionUtils.isEmpty(empList)) {

		for (Employee emp : empList) {

		    retList.add(transform(emp));

		}
	    }

	    return retList;

	};
    }

    /**
     * transforms single Employee object to HierarchyView
     * 
     * @param emp
     *            - <code>Employee</code> object to be transformed
     * @return <code>HierarchyView</code>
     */
    private static HierarchyView transform(Employee emp) {

	HierarchyView view = new HierarchyView();
	view.setName(emp.getName());

	if (!emp.getType().isLeastLevel()) {
	    /**
	     * least level does not have any team members
	     */
	    List<Employee> myTeam = emp.getTeam();

	    if (!CollectionUtils.isEmpty(myTeam)) {

		for (Employee teamMem : myTeam) {

		    view.addSubHierarchy(transform(teamMem));

		}
	    }
	}

	return view;
    }
}
