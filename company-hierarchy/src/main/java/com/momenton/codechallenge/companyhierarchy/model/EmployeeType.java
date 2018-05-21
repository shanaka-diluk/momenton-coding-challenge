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
     * checks whether this belongs to a top level type
     * 
     * @return true/false
     */
    public boolean isTopLevel() {
	Optional<EmployeeType> foundObj = Arrays.stream(topLevelTypes).filter(ele -> ele.equals(this)).findFirst();
	return foundObj.isPresent();
    }
    
    /**
     * checks whether this belongs to a least level type
     * 
     * @return true/false
     */
    public boolean isLeastLevel() {
	Optional<EmployeeType> foundObj = Arrays.stream(leastLevelTypes).filter(ele -> ele.equals(this)).findFirst();
	return foundObj.isPresent();
	
    }
}
