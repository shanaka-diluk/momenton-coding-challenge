package com.momenton.codechallenge.companyhierarchy.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momenton.codechallenge.companyhierarchy.exception.HierarchyException;
import com.momenton.codechallenge.companyhierarchy.service.HierarchyService;
import com.momenton.codechallenge.companyhierarchy.utils.TestModelProducer;
import com.momenton.codechallenge.companyhierarchy.utils.TransformerFactory;
import com.momenton.codechallenge.companyhierarchy.view.HierarchyView;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HierarchyControllerTest {

    @Autowired
    private MockMvc mockMvc;   
    
    @MockBean
    HierarchyService service;
    
   @Test
    public void testGetFullHierarchy() throws Exception {
	
	List<HierarchyView> list = TransformerFactory.transformEmployeeToHierarchy().transorm(TestModelProducer.constructTopModelWithMulti());
        when(service.getHierarchy()).thenReturn(list);
        
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(list));
        
        this.mockMvc.perform(get("/api/hierarchy"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().json(objectMapper.writeValueAsString(list)))
        .andDo(print());
    }

   @Test
   public void testGetHierarchyForManager() throws Exception {
	
       int empId = 5;
       List<HierarchyView> list = TransformerFactory.transformEmployeeToHierarchy().transorm(TestModelProducer.constructTopModel());
       when(service.getHierarchy(empId)).thenReturn(list.get(0));
       
       ObjectMapper objectMapper = new ObjectMapper();
       System.out.println(objectMapper.writeValueAsString(list));
       
       this.mockMvc.perform(get("/api/hierarchy/".concat(String.valueOf(empId))))
       .andExpect(status().isOk())
       .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
       .andExpect(content().json(objectMapper.writeValueAsString(list.get(0))))
       .andDo(print());
   }
   
   @Test
   public void testEmployeeNotFound() throws Exception {
	
       int empId = 13654789;
       when(service.getHierarchy(empId)).thenThrow(HierarchyException.class);
              
       this.mockMvc.perform(get("/api/hierarchy/".concat(String.valueOf(empId))))
       .andExpect(status().isNotFound())
       .andDo(print());
   }
  

}
