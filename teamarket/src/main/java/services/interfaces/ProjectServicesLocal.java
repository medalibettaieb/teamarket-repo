package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Project;

@Local
public interface ProjectServicesLocal {
	List<Project> findAllProjects();
}
