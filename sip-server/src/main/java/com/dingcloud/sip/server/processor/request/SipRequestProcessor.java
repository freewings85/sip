package com.dingcloud.sip.server.processor.request;

import javax.sip.RequestEvent;

import com.dingcloud.sip.server.SipProcessor;

/**
 * @author chenzifei
 * @date 2021年6月30日
 */
public abstract class SipRequestProcessor implements SipProcessor {
	private final RequestEvent requestEvent;

	public SipRequestProcessor(RequestEvent requestEvent) {
		this.requestEvent = requestEvent;
	}
	
	
}
