package com.dingcloud.sip.server.processor.response;

import javax.sip.ResponseEvent;

import com.dingcloud.sip.server.SipProcessor;

/**
 * processor of response
 * 
 * @author chenzifei
 * @date 2021年6月30日
 */
public abstract class SipResponseProcessor implements SipProcessor {
	private final ResponseEvent responseEvent;

	public SipResponseProcessor(ResponseEvent responseEvent) {
		this.responseEvent = responseEvent;
	}
}
