package com.momenton.codechallenge.companyhierarchy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Persistence entity for Employee
 *
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Integer Id;

    @Column(name = "NAME")    
    private String name;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)    
    private EmployeeType type;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager", cascade = CascadeType.PERSIST)
    private List<Employee> team = new ArrayList<>();

    @Transient
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    protected Employee() {
    }

    /**
     * custom constructor 
     * 
     * @param name - employee name
     * @param type - employee type
     * @param manager - manager of the employee, null for top level employee
     */
    public Employee(String name, EmployeeType type) {

	if ((name == null) || name.trim().equals("")) {
	    LOG.error("Employee should have a name");
	    throw new IllegalArgumentException("Unsatisfied arguments");	    
	}
	
	if (type == null) {
	    LOG.error("Employee type should be there for an employee");
	    throw new IllegalArgumentException("Unsatisfied arguments");
	}
		
	this.name = name;
	this.type = type;
	
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the type
     */
    public EmployeeType getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(EmployeeType type) {
	this.type = type;
    }

    /**
     * @return the team
     */
    public List<Employee> getTeam() {
	return team;
    }

    /**
     * @param team
     *            the team to set
     */
    public void setTeam(List<Employee> team) {
	this.team = team;
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return Id;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * @return the manager
     */
    public Employee getManager() {
	return manager;
    }
    
    /**
     * construct the team members of this employee
     * @param emp - team member
     */
    public void addToTeam(Employee emp) {
	emp.setManager(this);
	team.add(emp);
    }


}
