package com.momenton.codechallenge.companyhierarchy.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.model.EmployeeType;

/**
 * repository test cases
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repo;

    @Test
    public void testPersistHierarchy() {

	Employee ceo = new Employee("John Citizen", EmployeeType.CEO);
	ceo.addToTeam(new Employee("Bob Harper", EmployeeType.MANAGER));
	ceo.addToTeam(new Employee("David Miller", EmployeeType.MANAGER));

	ceo = repo.save(ceo);
	assertNotNull(ceo.getTeam());
	assertEquals(2, ceo.getTeam().size());

	Optional<String> ret = ceo.getTeam().stream().map(Employee::getName).filter(Arrays.asList("Bob Harper", "David Miller")::contains).findFirst();

	assertTrue(ret.isPresent());

    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
	new Employee(null, EmployeeType.CEO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
	new Employee("  ", EmployeeType.CEO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEmployeeType() {
	new Employee("David Miller", null);
    }

}
