package team2.PBL_AD_Manager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.adType.Ad;

@Repository
@RequiredArgsConstructor
@Transactional
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

	// AdRepository.java
	public Long findTotalNumber() {
		String jpql = "SELECT COUNT(a) FROM Ad a";
		return em.createQuery(jpql, Long.class).getSingleResult();
	}

	public List<Ad> findAllWithPagination(int startIdx, int entIdx) {
		String jpql = "SELECT a FROM Ad a WHERE a.id >= :startIdx AND a.id <= :entIdx";
		return em.createQuery(jpql, Ad.class)
			.setParameter("startIdx", startIdx)
			.setParameter("entIdx", entIdx)
			.getResultList();
	}

	/**
	 * 타겟 광고 찾는 코드
	 */
	// public Ad findTargetAd(){
	// 	em.createQuery();
	// }
}

