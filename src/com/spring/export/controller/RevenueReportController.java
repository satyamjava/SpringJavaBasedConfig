package com.spring.export.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.export.domain.User;
import com.spring.export.view.PdfRevenueReportView;

@Controller
public class RevenueReportController extends AbstractController{
	
	@Autowired
	@Qualifier("userA")
	private User user;
	
	@Autowired
	@Qualifier("PdfRevenueSummary")
	private PdfRevenueReportView pdfRevenueSummary;
	
	@Override
	@RequestMapping(value="/revenuereport.htm")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");      
		response.setHeader("Content-Disposition", "attachment; filename=file.pdf"); 
		
		//dummy data
		Map<String,String> revenueData = new HashMap<String,String>();
		revenueData.put("1/20/2010", "$100,000");
		revenueData.put("1/21/2010", "$200,000");
		revenueData.put("1/22/2010", "$300,000");
		revenueData.put("1/23/2010", "$400,000");
		revenueData.put("1/24/2010", "$500,000");
		System.out.println(user.getName());
		return new ModelAndView(pdfRevenueSummary,"revenueData",revenueData);
	}
	
}