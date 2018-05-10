package com.company.controller;

import org.junit.Before;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class BaseControllerTest {

	public final static String PATH_RESOURCES = "src/test/resources/";

	final WebMvcConfigurationSupport webMvcConfigSupport = new WebMvcConfigurationSupport();

	final StaticApplicationContext applicationContext = new StaticApplicationContext();

	@Before
	public void setUp() throws Exception {
		webMvcConfigSupport.setApplicationContext(applicationContext);
		applicationContext.registerSingleton("exceptionHandler", GlobalExceptionHandlerExceptionTest.class);
	}

}
