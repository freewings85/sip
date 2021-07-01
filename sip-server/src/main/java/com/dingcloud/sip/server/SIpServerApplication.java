package com.dingcloud.sip.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author chenzifei
 * @date 2020年9月10日
 */
@SpringBootApplication
@EnableAsync
public class SIpServerApplication {
	private static String configFile = "//conf//application.properties";
	private static final String SIP_PROPERTY_ENV = "SERVER_HOME";
	private static final String SIP_PROPERTY_PROP = "home.dir";
	private static String serverHome = System.getProperty(SIP_PROPERTY_PROP, System.getenv(SIP_PROPERTY_ENV));

	public static void main(String[] args) {
		System.setProperty(SIP_PROPERTY_ENV, serverHome);
		String applicationFile = serverHome + configFile;
		System.setProperty("spring.config.location", applicationFile);
		try {
			SpringApplication.run(SIpServerApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
