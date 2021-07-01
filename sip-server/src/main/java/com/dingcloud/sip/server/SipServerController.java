package com.dingcloud.sip.server;

import javax.sip.SipListener;

/**
 * sip server controller
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
public class SipServerController {
	private SipServerConfig config;
	private SipListener listener;
	private SipStackContext sipContext;

	public SipServerController(SipServerConfig config) {
		this.config = config;
		this.sipContext = new SipStackContext();
		this.listener = new DefaultSipListener();
	}

	public void init() throws Exception {
		sipContext.init(config, listener);
	}

}
