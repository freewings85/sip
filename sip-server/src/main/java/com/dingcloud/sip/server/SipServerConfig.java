package com.dingcloud.sip.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * config of sip server
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
@Configuration
@ConfigurationProperties(prefix = "sip")
public class SipServerConfig {
	// udp端口, <=0时不开启
	private int udpPort = 5060;
	// tcp端口, <=0时不开启
	private int tcpPort = 5060;
	// event executor threads
	private int eventExecutorNum = 1;

	public int getUdpPort() {
		return udpPort;
	}

	public void setUdpPort(int udpPort) {
		this.udpPort = udpPort;
	}

	public int getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}

	public int getEventExecutorNum() {
		return eventExecutorNum;
	}

	public void setEventExecutorNum(int eventExecutorNum) {
		this.eventExecutorNum = eventExecutorNum;
	}

}
