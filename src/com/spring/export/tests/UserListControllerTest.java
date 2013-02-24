package com.spring.export.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import com.spring.export.configuration.UserConfig;
import com.spring.export.controller.UserListController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={UserConfig.class})
public class UserListControllerTest {
	private UserListController controller;
	 
    @Before
    public void init(){
 
    controller = new UserListController();
    }

    @Test
    public void test() throws Exception{
 
    	String user = controller.showForm(new ModelMap());
         assertNotNull(user);
    }
 
    @After
    public void destroy(){
        controller = null;
    }
}
