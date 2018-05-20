package com.momenton.codechallenge.companyhierarchy.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * enum for defining employee types
 *
 */
public enum EmployeeType {

    CEO, MANAGER, NORMAL;

    /**
     * define the top level employee types
     */
    private static EmployeeType[] topLevelTypes = { EmployeeType.CEO };
    
    /**
     * define the least level employee type
     */
    private static EmployeeType[] leastLevelTypes = {EmployeeType.NORMAL};
    
    /**
     * checks whether argument belongs to a top level type
     * 
     * @param type - <code>EmployeeType</code> to be checked
     * @return true/false
     */
    public static boolean isTopLevel(EmployeeType type) {
	Optional<EmployeeType> foundObj = Arrays.stream(topLevelTypes).filter(ele -> ele.equals(type)).findFirst();
	return foundObj.isPresent();
    }
    
    /**
     * checks whether argument belongs to a least level type
     * 
     * @param type - <code>EmployeeType</code> to be checked
     * @return true/false
     */
    public static boolean isLeastLevel(EmployeeType type) {
	Optional<EmployeeType> foundObj = Arrays.stream(leastLevelTypes).filter(ele -> ele.equals(type)).findFirst();
	return foundObj.isPresent();
	
    }
}
