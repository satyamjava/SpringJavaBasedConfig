package com.spring.export.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.export.view.PdfRevenueReportView;

@EnableWebMvc
@Configuration
@ComponentScan("com.spring.export.*")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public PdfRevenueReportView PdfRevenueSummary() {
		return new PdfRevenueReportView();
	}
    
	
	
	/**
     * ViewResolver configuration required to work with xml/pdf views.
     */
  /*  @Bean
    @DependsOn("PdfRevenueSummary")
    public XmlViewResolver xmlViewResolver() {
    	XmlViewResolver xmlViewResolver = new XmlViewResolver();
    	//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/WEB-INF/spring-pdf-views.xml");
    	//XmlWebApplicationContext ctx = new XmlWebApplicationContext();
		//Resource resource = ctx.getResource("classpath:/WEB-INF/spring-pdf-views.xml");
    	//Resource resource = new FileSystemResource("/WEB-INF/spring-pdf-views.xml");
		//Resource resource = new ClassPathResource("/WEB-INF/spring-pdf-views.xml");
		//xmlViewResolver.setLocation(resource);
    	//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	//ctx.getBeansOfType(PdfRevenueReportView.class);
    	//xmlViewResolver.setApplicationContext(ctx);
    	//Resource resource = new ClassPathResource("classpath*:WEB-INF/views.xml");
    //	xmlViewResolver.setLocation(resource);
	    xmlViewResolver.setOrder(1);
       
        return xmlViewResolver;
    }*/
    
    
    /**
     * ViewResolver configuration required to work with resource-based views.
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
    	InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    	internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
    	internalResourceViewResolver.setSuffix(".jsp");
    	internalResourceViewResolver.setOrder(0);
        return internalResourceViewResolver;
    }

}
