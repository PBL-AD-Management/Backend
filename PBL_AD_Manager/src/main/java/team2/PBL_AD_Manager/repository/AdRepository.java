package team2.PBL_AD_Manager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.adType.Ad;

@Repository
@RequiredArgsConstructor
public class AdRepository {

	private final EntityManager em;

	public void saveAd(Ad ad) {
		em.persist(ad);
	}

	public Ad findOne(Long id) {
		return em.find(Ad.class, id);
	}

	public List<Ad> findAds() {
		return em.createQuery("select a from Ad a", Ad.class).getResultList();
	}

	/**
	 * 타겟 광고 찾는 코드
	 */
	// public Ad findTargetAd(){
	// 	em.createQuery();
	// }
}

