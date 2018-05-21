package com.momenton.codechallenge.companyhierarchy.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

/**
 * view representation of the hierarchy.
 * 
 */
@ApiModel(description = "Details about the hierarchy view")
public class HierarchyView {

    /**
     * name of the employee
     */
    private String name;
    
    /**
     * sub hierarchy of the employee, for the least level employees this is empty
     * jackson will ignore empty lists
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)	
    private List<HierarchyView> subHierarchy = new ArrayList<>();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subHierarchy
     */
    public List<HierarchyView> getSubHierarchy() {
        return subHierarchy;
    }

    /**
     * @param subHierarchy the subHierarchy to set
     */
    public void setSubHierarchy(List<HierarchyView> subHierarchy) {
        this.subHierarchy = subHierarchy;
    }

    /**
     * adds a sub hierarchy to the list.
     * 
     * @param sub - hierarchy to be added
     */
    public void addSubHierarchy(HierarchyView sub) {
	subHierarchy.add(sub);
    }
}
