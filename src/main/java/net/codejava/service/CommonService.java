package net.codejava.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.codejava.bean.Application;
import net.codejava.bean.Environment;
import net.codejava.bean.Server;



/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class CommonService {

 static HashMap<Integer,Environment> envIdMap=getEnvironmentIdMap();
 static HashMap<Integer,Application> appIdMap=getApplicationIdMap();
 


 public CommonService() {
  super();

  if(envIdMap==null)
  {
	  envIdMap=new HashMap<Integer,Environment>();
  // Creating some objects of Country while initializing
   Environment dev=new Environment(101, "Dev");
   Environment sit=new Environment(102, "SIT");
   Environment tt=new Environment(103, "TT");



   envIdMap.put(101,dev);
   envIdMap.put(102,sit);
   envIdMap.put(103,tt);

  }
  
  
  if(appIdMap==null)
  {
	  appIdMap=new HashMap<Integer,Application>();
  // Creating some objects of Country while initializing
   Application r1=new Application(712, "r1");
   Application r2=new Application(713, "r2");
   Application c1=new Application(172, "c1");



   appIdMap.put(712,r1);
   appIdMap.put(713,r2);
   appIdMap.put(172,c1);

  }
  
 }

 public List<Environment> getAllEnvironments()
 {
  List<Environment> environments = new ArrayList<Environment>(envIdMap.values());
  return environments;
 }

 public Environment getEnvironment(int id)
 {
	 Environment environment= envIdMap.get(id);
  return environment;
 }


 public List<Server> getSevers(int appId, int envId)
 {
  List<Server> servers = new ArrayList<Server>();
  System.out.println("appId:"+appId  + ">>>envId:"+envId);
  
  servers.add(new Server(1101,"101"));
  servers.add(new Server(1105,"102"));
  return servers;
 }


 public static HashMap<Integer, Environment> getEnvironmentIdMap() {
  return envIdMap;
 }
 
 
 public static HashMap<Integer, Application> getApplicationIdMap() {
	  return appIdMap;
	 }
	 
 public List<Application> getAllApplications()
 {
  List<Application> applications = new ArrayList<Application>(appIdMap.values());
  return applications;
 }

 public Application getApplication(int id)
 {
	 Application application= appIdMap.get(id);
  return application;
 }

 
}

