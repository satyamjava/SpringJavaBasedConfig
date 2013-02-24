package com.spring.export.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DeploymentDescripterConfig implements WebApplicationInitializer {
	 
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		// Create the 'root' Spring application context
	    AnnotationConfigWebApplicationContext rootContext  = new AnnotationConfigWebApplicationContext();
	    rootContext.scan("com.spring.export.*");
	    servletContext.addListener(new ContextLoaderListener(rootContext));
	    
	    
	    ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(new GenericWebApplicationContext()));
	    appServlet.setLoadOnStartup(1); 

	    appServlet.addMapping("*.htm");
	    

    }
 
}
