package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.ProjectServicesLocal;
import services.interfaces.ProjectServicesRemote;
import domain.Project;

@Stateless
public class ProjectServices implements ProjectServicesLocal,
		ProjectServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Project> findAllProjects() {
		return entityManager.createQuery("select p from Project p",Project.class)
				.getResultList();
	}

}
