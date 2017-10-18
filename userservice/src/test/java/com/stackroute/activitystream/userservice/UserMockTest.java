package com.stackroute.activitystream.userservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT,classes = UserServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserMockTest {

	@Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
   
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void getAllUserTest() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/getAllUsers"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
   
 //   @Test
    public void getUserByEmail() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/getUser/zaid3891@gmail.com"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

 //   @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/getAllUsers"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}