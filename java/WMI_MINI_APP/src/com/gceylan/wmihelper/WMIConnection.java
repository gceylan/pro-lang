package com.gceylan.wmihelper;

import com.jacob.activeX.ActiveXComponent;

public class WMIConnection {
	private String host = null;
	private String connectionString = null;

	public WMIConnection(String host) {
		this.host = host;
		this.connectionString = String.format("winmgmts:\\\\%s\\root\\CIMV2", host);
	}

	public ActiveXComponent setConnection() {
		return new ActiveXComponent(connectionString);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
