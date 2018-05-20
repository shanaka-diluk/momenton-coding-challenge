package com.momenton.codechallenge.companyhierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
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

    public Employee(@NotNull String name, @NotNull EmployeeType type, Employee manager) {

	if (!EmployeeType.isTopLevel(type) && Objects.isNull(manager)) {
	    /**
	     * prevent the construction as for every non top level employees should have a
	     * manager. fair assumption
	     */
	    LOG.error("Every non top employees should have a manager.");
	    throw new IllegalArgumentException("Unsatisfied arguments");
	}
	
	this.name = name;
	this.type = type;
	this.manager = manager;
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
     * @return the manager
     */
    public Employee getManager() {
	return manager;
    }
    
    public void addToTeam(Employee emp) {
	team.add(emp);
    }

}
