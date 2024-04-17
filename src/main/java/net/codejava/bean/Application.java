package net.codejava.bean;

public class Application{
	
	int id;
	String appName;	

	
	public Application() {
		super();
	}
	public Application(int i, String appName) {
		super();
		this.id = i;
		this.appName = appName;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}

	
}