package mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import services.interfaces.ProjectServicesLocal;
import domain.Project;

@ManagedBean
@ViewScoped
public class ProjectBean {

	private List<Project> projects;
	@EJB
	private ProjectServicesLocal projectServicesLocal;

	@PostConstruct
	public void initProjects() {
		projects = projectServicesLocal.findAllProjects();
	}

	public String doDeploy() {
		System.out.println("ahhhhhhhhhhhh");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path(
				"/job/teamarketJob/build");

		target.request(MediaType.APPLICATION_JSON_TYPE).post(null);

		return "";
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
