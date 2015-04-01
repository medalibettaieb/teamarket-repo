package services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Project;

@Singleton
@Startup
public class PopulateDb {
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void initDb() {

		Project project = new Project("kiko");
		Project project2 = new Project("dido");

		entityManager.persist(project);
		entityManager.persist(project2);

	}
}
