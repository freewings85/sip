package com.dingcloud.sip.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.sip.SipListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.dingcloud.common.NamedThreadFactory;

/**
 * sip server controller
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
@Component
public class SipServerController implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
	private static final Logger logger = LoggerFactory.getLogger(SipServerController.class);
	private SipServerConfig config;
	private SipListener listener;
	private SipStackContext sipContext;
	private SipProcessorFactory factory;
	private ExecutorService eventExecutor;

	public SipServerController(SipServerConfig config) {
		this.config = config;
		this.sipContext = new SipStackContext();
		this.factory = new SipProcessorFactory();
		this.eventExecutor = new ThreadPoolExecutor(config.getEventExecutorNum(), config.getEventExecutorNum(), 60000,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new NamedThreadFactory("SipEventHandler-"));
		this.listener = new DefaultSipListener(factory, eventExecutor);
	}

	@PostConstruct
	public void init() throws Exception {
		sipContext.init(config, listener);
	}

	public void start() {

	}

	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		try {
			logger.info("sip server start begin.");
			start();
			logger.info("sip server start successfully.");
		} catch (Exception e) {
			logger.error("sip server start exception.", e);
			System.exit(-2);
		}
	}

}
