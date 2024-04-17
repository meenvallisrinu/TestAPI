package net.codejava.bean;

public class Server{
	
	int id;
	String serverName;	

	
	public Server() {
		super();
	}
	public Server(int i, String serverName) {
		super();
		this.id = i;
		this.serverName = serverName;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	
}