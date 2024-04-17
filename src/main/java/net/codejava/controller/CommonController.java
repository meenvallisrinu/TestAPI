package net.codejava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.bean.Application;
import net.codejava.bean.Environment;
import net.codejava.bean.Server;
import net.codejava.service.CommonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommonController {

	CommonService commonService = new CommonService();

	@RequestMapping(value = "/applications", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Application> getApplications() {
		List<Application> listOfApplications= commonService.getAllApplications();
		return listOfApplications;
	}
	
	@RequestMapping(value = "/environments", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Environment> getEnvironments() {
		List<Environment> listOfEnvironments= commonService.getAllEnvironments();
		return listOfEnvironments;
	}

	@RequestMapping(value = "/servers/{appId}/{envId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Server> getServers(@PathVariable int appId, @PathVariable  int envId) {
		List<Server> listOfServers= commonService.getSevers(appId,envId);
		return listOfServers;
	}
}
