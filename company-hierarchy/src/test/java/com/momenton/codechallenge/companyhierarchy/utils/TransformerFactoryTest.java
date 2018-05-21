package com.momenton.codechallenge.companyhierarchy.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

/**
 * test cases for view transformer
 *
 */
public class TransformerFactoryTest {

    @Test
    public void testEmployeeToHierarchy() {
	
	List<Employee> list = TestModelProducer.constructTopModel();
	
	List<HierarchyView> retList = TransformerFactory.transformEmployeeToHierarchy().transorm(list);
	
	assertNotNull(retList);
	assertEquals(1, retList.size());
	
	HierarchyView view = retList.get(0);
	assertEquals("Robert William", view.getName());
	
	List<HierarchyView> topTeam = view.getSubHierarchy();
	assertNotNull(topTeam);
	assertEquals(2, topTeam.size());
	
	assertEquals("David Miller", topTeam.get(0).getName());
	assertEquals("Mark Weber", topTeam.get(1).getName());
	
	assertEquals(1, topTeam.get(0).getSubHierarchy().size());
	assertEquals(0, topTeam.get(1).getSubHierarchy().size());
	
	assertEquals("John Citizen", topTeam.get(0).getSubHierarchy().get(0).getName());	
	
    }
    
    @Test    
    public void testEmployeeToHierarchyWithMultiTopLevel() {
	
	List<Employee> list = TestModelProducer.constructTopModelWithMulti();
	
	List<HierarchyView> retList = TransformerFactory.transformEmployeeToHierarchy().transorm(list);
	
	assertNotNull(retList);
	assertEquals(2, retList.size());	
	
	assertEquals("Robert William", retList.get(0).getName());
	assertEquals("COO", retList.get(1).getName());
	
	assertEquals(1, retList.get(1).getSubHierarchy().size());	
	assertEquals("Tom Jones", retList.get(1).getSubHierarchy().get(0).getName());
	
    }

    @Test
    public void testNullEmptyInput() {
	
	List<HierarchyView> retList = TransformerFactory.transformEmployeeToHierarchy().transorm(null);	
	assertNotNull(retList);
	assertEquals(0, retList.size());
	
	retList = TransformerFactory.transformEmployeeToHierarchy().transorm(new ArrayList<>());
	assertNotNull(retList);
	assertEquals(0, retList.size());
	
	
    }
    
  
    
    

}
