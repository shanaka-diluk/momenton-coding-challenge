package com.momenton.codechallenge.companyhierarchy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.repository.EmployeeRepository;
import com.momenton.codechallenge.companyhierarchy.utils.TestModelProducer;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

/**
 * service layer test cases
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HierarchyServiceImplTest {

    @MockBean
    EmployeeRepository repo;

    @Autowired
    HierarchyService service;

    @Test
    public void testHierarchy() {

	when(repo.findTopLevel()).thenReturn(TestModelProducer.constructTopModelWithMulti());

	List<HierarchyView> view = service.getHierarchy();

	assertNotNull(view);
	assertEquals(2, view.size());
	assertEquals("Robert William", view.get(0).getName());
	assertEquals("COO", view.get(1).getName());

	assertNotNull(view.get(0).getSubHierarchy());
	assertEquals(2, view.get(0).getSubHierarchy().size());

	assertNotNull(view.get(1).getSubHierarchy());
	assertEquals(1, view.get(1).getSubHierarchy().size());

    }

    @Test(expected = HierarchyException.class)
    public void testIndividualHierarchyNotFound() throws HierarchyException {
	int empId = 100;

	when(repo.findById(empId)).thenReturn(Optional.empty());

	service.getHierarchy(empId);
    }

    @Test
    public void testIndividualHierarchy() throws HierarchyException {
	int empId = 100;

	when(repo.findById(empId)).thenReturn(Optional.of(TestModelProducer.constructTopModel().get(0)));

	HierarchyView view = service.getHierarchy(empId);

	assertNotNull(view);
	assertEquals("Robert William", view.getName());

	assertNotNull(view.getSubHierarchy());
	assertEquals(2, view.getSubHierarchy().size());

    }

}
