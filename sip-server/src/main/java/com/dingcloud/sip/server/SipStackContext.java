package com.dingcloud.sip.server;

import java.util.Properties;

import javax.sip.ListeningPoint;
import javax.sip.SipFactory;
import javax.sip.SipListener;
import javax.sip.SipProvider;
import javax.sip.SipStack;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

/**
 * sip stack context
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
public class SipStackContext {
	// jain-sip
	private SipStack sipStack;
	private ListeningPoint udpListeningPoint;
	private SipProvider udpProvider;
	private ListeningPoint tcpListeningPoint;
	private SipProvider tcpProvider;
	private AddressFactory addressFactory;
	private MessageFactory messageFactory;
	private HeaderFactory headerFactory;

	public void init(SipServerConfig config, SipListener listener) throws Exception {
		SipFactory sipFactory = SipFactory.getInstance();
		sipFactory.setPathName("gov.nist");
		Properties properties = new Properties();

		properties.setProperty("javax.sip.STACK_NAME", "controller");
		sipStack = sipFactory.createSipStack(properties);
		headerFactory = sipFactory.createHeaderFactory();
		addressFactory = sipFactory.createAddressFactory();
		messageFactory = sipFactory.createMessageFactory();
		if (config.getUdpPort() > 0) {
			udpListeningPoint = sipStack.createListeningPoint("127.0.0.1", config.getUdpPort(), "udp");
			udpProvider = sipStack.createSipProvider(udpListeningPoint);
			udpProvider.addSipListener(listener);
		}
		if (config.getTcpPort() > 0) {
			tcpListeningPoint = sipStack.createListeningPoint("127.0.0.1", config.getTcpPort(), "tcp");
			tcpProvider = sipStack.createSipProvider(tcpListeningPoint);
			tcpProvider.addSipListener(listener);
		}
	}

	public SipStack getSipStack() {
		return sipStack;
	}

	public void setSipStack(SipStack sipStack) {
		this.sipStack = sipStack;
	}

	public ListeningPoint getUdpListeningPoint() {
		return udpListeningPoint;
	}

	public void setUdpListeningPoint(ListeningPoint udpListeningPoint) {
		this.udpListeningPoint = udpListeningPoint;
	}

	public SipProvider getUdpProvider() {
		return udpProvider;
	}

	public void setUdpProvider(SipProvider udpProvider) {
		this.udpProvider = udpProvider;
	}

	public ListeningPoint getTcpListeningPoint() {
		return tcpListeningPoint;
	}

	public void setTcpListeningPoint(ListeningPoint tcpListeningPoint) {
		this.tcpListeningPoint = tcpListeningPoint;
	}

	public SipProvider getTcpProvider() {
		return tcpProvider;
	}

	public void setTcpProvider(SipProvider tcpProvider) {
		this.tcpProvider = tcpProvider;
	}

	public AddressFactory getAddressFactory() {
		return addressFactory;
	}

	public void setAddressFactory(AddressFactory addressFactory) {
		this.addressFactory = addressFactory;
	}

	public MessageFactory getMessageFactory() {
		return messageFactory;
	}

	public void setMessageFactory(MessageFactory messageFactory) {
		this.messageFactory = messageFactory;
	}

	public HeaderFactory getHeaderFactory() {
		return headerFactory;
	}

	public void setHeaderFactory(HeaderFactory headerFactory) {
		this.headerFactory = headerFactory;
	}

}
