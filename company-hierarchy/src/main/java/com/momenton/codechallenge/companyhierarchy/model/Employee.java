package com.momenton.codechallenge.companyhierarchy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Persistence entity for Employee
 *
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMP_ID")
    private Integer Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private EmployeeType type;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
    private List<Employee> team;

    protected Employee() {
    }

    public Employee(@NotNull EmployeeType type, Employee manager) {
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

}
