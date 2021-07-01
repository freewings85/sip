package com.dingcloud.sip.server;

import org.junit.Before;
import org.junit.Test;

/**
 * test of controller
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
public class SipControllerTest {
	private SipServerController controller;
	private SipServerConfig config;

	@Before
	public void init() {
		config = new SipServerConfig();
		config.setUdpPort(5070);
		config.setTcpPort(5070);
		controller = new SipServerController(config);
	}

	@Test
	public void testInit() {
		try {
			controller.init();
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
