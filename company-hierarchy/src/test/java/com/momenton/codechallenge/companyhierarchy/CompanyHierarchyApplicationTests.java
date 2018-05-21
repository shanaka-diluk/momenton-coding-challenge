package com.momenton.codechallenge.companyhierarchy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.momenton.codechallenge.companyhierarchy.controller.HierarchyController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyHierarchyApplicationTests {

    @Autowired
    private HierarchyController controller;
    
	@Test
	public void contextLoads() {
	    assertThat(controller).isNotNull();
	}

}
