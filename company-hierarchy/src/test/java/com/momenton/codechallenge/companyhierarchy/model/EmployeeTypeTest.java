package com.momenton.codechallenge.companyhierarchy.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * test cases for EmployeeType
 *
 */
public class EmployeeTypeTest {

    @Test
    public void testTopLevel() {
	
	assertTrue(EmployeeType.CEO.isTopLevel());
	assertFalse(EmployeeType.MANAGER.isTopLevel());
	
	
	EmployeeType[] topLevel = (EmployeeType[])ReflectionTestUtils.getField(EmployeeType.class, "topLevelTypes");
	
	Arrays.stream(topLevel).forEach(ele -> {
	    
	    assertTrue(ele.isTopLevel());
	});
    }

    @Test
    public void testLeastLevel() {
	
	assertTrue(EmployeeType.CEO.isTopLevel());
	assertFalse(EmployeeType.MANAGER.isTopLevel());
	assertTrue(EmployeeType.NORMAL.isLeastLevel());
	
	
	EmployeeType[] topLevel = (EmployeeType[])ReflectionTestUtils.getField(EmployeeType.class, "leastLevelTypes");
	
	Arrays.stream(topLevel).forEach(ele -> {
	    
	    assertTrue(ele.isLeastLevel());
	});
    }

}
