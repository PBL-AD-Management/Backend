package team2.PBL_AD_Manager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Contracts;

@Repository
@Transactional
@RequiredArgsConstructor
public class ContractsRepository {

	private final EntityManager em;

	public void saveContract(Contracts contracts) {
		em.persist(contracts);
	}

	public Contracts findContract(Long contractId) {
		return em.find(Contracts.class, contractId);
	}

	// Ad 테이블의 ad_id로 계약 테이블 조회
	public Contracts findContractByAdId(Long ad_id) {
		String jpql = "SELECT Contracts FROM Contracts WHERE Contracts.ad = :ad_id";
		return em.createQuery(jpql, Contracts.class).setParameter("ad_id", ad_id).getSingleResult();
	}
}
