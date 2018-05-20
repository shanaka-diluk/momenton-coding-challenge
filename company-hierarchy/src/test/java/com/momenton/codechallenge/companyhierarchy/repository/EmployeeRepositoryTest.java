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
import org.springframework.transaction.annotation.Transactional;

import com.momenton.codechallenge.companyhierarchy.model.Employee;
import com.momenton.codechallenge.companyhierarchy.model.EmployeeType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repo;
    
    @Test
    @Transactional
    public void persistHierarchy() {
	
	Employee ceo = new Employee("John Citizen",EmployeeType.CEO, null);
	ceo.addToTeam(new Employee("Bob Harper", EmployeeType.MANAGER, ceo) );
	ceo.addToTeam(new Employee("David Miller", EmployeeType.MANAGER, ceo));
	
	ceo = repo.save(ceo);
	assertNotNull(ceo.getTeam());
	assertEquals(2, ceo.getTeam().size());
	
	
	Optional<String> ret = ceo.getTeam().stream().map(Employee::getName).filter(Arrays.asList("Bob Harper", "David Miller")::contains).findFirst();
	
	assertTrue(ret.isPresent());
	
	
    }
}
