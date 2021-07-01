package com.dingcloud.sip.server;

/**
 * config of sip server
 * 
 * @author chenzifei
 * @date 2021年6月29日
 */
public class SipServerConfig {
	// udp端口, <=0时不开启
	private int udpPort = 5060;
	// tcp端口, <=0时不开启
	private int tcpPort = 5060;

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

}
