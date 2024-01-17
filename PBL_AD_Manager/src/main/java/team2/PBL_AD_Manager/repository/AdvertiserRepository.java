package team2.PBL_AD_Manager.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Advertiser;

@Repository
@RequiredArgsConstructor

public class AdvertiserRepository {
	private final EntityManager em;

	public void saveAdvertiser(Advertiser advertiser) {
		em.persist(advertiser);
	}

	public Advertiser findAdvertiser(Long id) {
		return em.find(Advertiser.class, id);
	}
}
