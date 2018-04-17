package com.company;

import org.junit.Before;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.company.common.FileUtils;

public class BaseControllerTest {

	public final static String PATH_RESOURCES = "src/test/resources/";

	final WebMvcConfigurationSupport webMvcConfigSupport = new WebMvcConfigurationSupport();

	final StaticApplicationContext applicationContext = new StaticApplicationContext();

	@Before
	public void setUp() throws Exception {
		webMvcConfigSupport.setApplicationContext(applicationContext);
		applicationContext.registerSingleton("exceptionHandler", GlobalExceptionHandlerExceptionTest.class);
	}

	protected String read(String fileName) throws Exception {
		return FileUtils.read(String.format("%s%s", PATH_RESOURCES, fileName));
	}
}
