package com.dingcloud.sip.server;

import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.message.Request;

import com.dingcloud.sip.server.processor.request.AckProcessor;
import com.dingcloud.sip.server.processor.request.ByeProcessor;
import com.dingcloud.sip.server.processor.request.CancelProcessor;
import com.dingcloud.sip.server.processor.request.InviteProcessor;
import com.dingcloud.sip.server.processor.request.OptionsProcessor;
import com.dingcloud.sip.server.processor.request.OtherRequestProcessor;
import com.dingcloud.sip.server.processor.request.RegisterProcessor;

/**
 * processor builder
 * 
 * @author chenzifei
 * @date 2021年6月30日
 */
public class SipProcessorFactory {

	public SipProcessor createRequestProcessor(RequestEvent requestEvent) {
		String method = requestEvent.getRequest().getMethod();
		SipProcessor processor = null;
		switch (method) {
		case Request.ACK:
			processor = new AckProcessor(requestEvent);
			break;
		case Request.BYE:
			processor = new ByeProcessor(requestEvent);
			break;
		case Request.CANCEL:
			processor = new CancelProcessor(requestEvent);
			break;
		case Request.INVITE:
			processor = new InviteProcessor(requestEvent);
			break;
		case Request.OPTIONS:
			processor = new OptionsProcessor(requestEvent);
			break;
		case Request.REGISTER:
			processor = new RegisterProcessor(requestEvent);
			break;
		default:
			processor = new OtherRequestProcessor(requestEvent);
			break;
		}
		return processor;
	}

	public SipProcessor createResponseProcessor(ResponseEvent responseEvent) {
		// TODO
		return null;
	}
}
