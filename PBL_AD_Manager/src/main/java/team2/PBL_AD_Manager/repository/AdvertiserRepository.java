package team2.PBL_AD_Manager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Advertiser;

@Repository
@RequiredArgsConstructor
@Transactional
public class AdvertiserRepository {
	private final EntityManager em;

	public void saveAdvertiser(Advertiser advertiser) {
		em.persist(advertiser);
	}

	public Advertiser findAdvertiser(Long id) {
		return em.find(Advertiser.class, id);
	}

	public List<Advertiser> findAll() {
		return em.createQuery("select A from Advertiser A", Advertiser.class).getResultList();
	}
}
