package net.codejava.bean;

public class Environment{
	
	int id;
	String envName;	

	
	public Environment() {
		super();
	}
	public Environment(int i, String envName) {
		super();
		this.id = i;
		this.envName = envName;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}

	
}