package com.dingcloud.sip.server;

import java.util.concurrent.ExecutorService;

import javax.sip.DialogTerminatedEvent;
import javax.sip.IOExceptionEvent;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.SipListener;
import javax.sip.TimeoutEvent;
import javax.sip.TransactionTerminatedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * default impl of sip listener
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
public class DefaultSipListener implements SipListener {
	private static final Logger logger = LoggerFactory.getLogger(DefaultSipListener.class);
	// processor factory to build processor
	private SipProcessorFactory processorFactory;
	private ExecutorService processThreadPool;

	public DefaultSipListener(SipProcessorFactory factory, ExecutorService executor) {
		this.processorFactory = factory;
		this.processThreadPool = executor;
	}

	public void processRequest(RequestEvent requestEvent) {
		processThreadPool.execute(() -> {
			try {
				SipProcessor processor = processorFactory.createRequestProcessor(requestEvent);
				processor.process();
			} catch (Exception e) {
				logger.error("process request failed!", e);
			}
		});
	}

	public void processResponse(ResponseEvent responseEvent) {
		processThreadPool.execute(() -> {
			try {
				SipProcessor processor = processorFactory.createResponseProcessor(responseEvent);
				processor.process();
			} catch (Exception e) {
				logger.error("process response failed!", e);
			}
		});
	}

	public void processTimeout(TimeoutEvent timeoutEvent) {
		// TODO
		System.out.println("timeoutevent");
	}

	public void processIOException(IOExceptionEvent exceptionEvent) {
		// TODO
		System.out.println("io exception");
	}

	public void processTransactionTerminated(TransactionTerminatedEvent transactionTerminatedEvent) {
		// TODO
		System.out.println("transaction event");
	}

	public void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent) {
		// TODO
		System.out.println("dialog terminated");
	}

}
