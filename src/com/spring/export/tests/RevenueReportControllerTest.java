package com.spring.export.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.spring.export.configuration.WebConfig;
import com.spring.export.controller.RevenueReportController;
import com.spring.export.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RevenueReportControllerTest {
	private RevenueReportController controller;
	 
    @Before
    public void init(){
 
    controller = new RevenueReportController();
    }

    @Test
    public void test() throws Exception{
 
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        //request.addParameter("revenueData", revenueData);
        System.out.println(1111);
        MockHttpServletResponse response = new MockHttpServletResponse();
        try{
        	System.out.println(2222);
            ModelAndView modelAndView = controller.handleRequest(request, response);
            System.out.println(modelAndView);
            Assert.assertNotNull(modelAndView);
            System.out.println(3333);
            ModelAndViewAssert.assertAndReturnModelAttributeOfType(modelAndView, "revenueData", HashMap.class);
            ModelAndViewAssert.assertViewName(modelAndView, "pdfRevenueSummary");
            System.out.println(4444);
            Iterator<String> iterator = modelAndView.getModel().keySet().iterator();
            if (iterator.hasNext()){
 
                String key = iterator.next();
                String date = (String)modelAndView.getModel().get(key);
                System.out.println(date);
                Assert.assertEquals("1/20/2010", date);
            }else{
            }
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
    }
 
    @After
    public void destroy(){
        controller = null;
    }
}
