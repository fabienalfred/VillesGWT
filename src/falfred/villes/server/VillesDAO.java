package falfred.villes.server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import falfred.villes.shared.Ville;

public class VillesDAO {

	private EntityManagerFactory emf;
	
	public VillesDAO() {
		emf = Persistence.createEntityManagerFactory("france");
	}
	
	@SuppressWarnings("unchecked")
	public List<Ville> getAllVilles() {
		EntityManager em = emf.createEntityManager();
		List<Ville> villes = em.createNamedQuery("SELECT * FROM Ville")
				.getResultList();
		em.close();
		return villes;
	}
	
}
