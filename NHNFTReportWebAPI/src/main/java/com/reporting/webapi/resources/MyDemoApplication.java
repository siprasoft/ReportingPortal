package com.reporting.webapi.resources;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

public class MyDemoApplication extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/
	public MyDemoApplication(){
		//System.out.println("hi");
		/*register(RequestContextFilter.class);
		register(RestServiceUsingJersey.class);
		register(ServiceYearImpl.class);
		register(YearDaoImpl.class);
		register(JacksonFeature.class);*/
		
		/**
		 * Register JAX-RS application components.
		 */
		
			
	        packages("com.reporting.webapi");

			// register features
			EncodingFilter.enableFor(this, GZipEncoder.class);		
			
	

	}
}