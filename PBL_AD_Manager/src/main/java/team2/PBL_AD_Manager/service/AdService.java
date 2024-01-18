package team2.PBL_AD_Manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.repository.AdRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdService {
	private final AdRepository adRepository;

	@Transactional
	public void saveAd(Ad ad) {
		adRepository.saveAd(ad);
	}

	@Transactional
	/**
	 * 수정할때 수정할 정보를 추가 매개변수로 넣어주면 됨
	 */
	public void update(Long adId) {
		Ad findAd = adRepository.findOne(adId);
		/*
		findAd.set,,을 통해 수정할 정보 수정
		 */
	}

	/**
	 * 해당 ad 를 DB 에서 삭
	 * @param adId
	 */
	public void delete(Long adId) {

	}

	public List<Ad> findAds() {
		return adRepository.findAds();
	}

	public Ad findOne(Long id) {
		return adRepository.findOne(id);
	}

	// AdService.java

	public List<Ad> findAdsByPage(int pageNum) throws Exception {
		int unitNum = 5; // 각 페이지에 표시할 광고 수
		Long totalNum = adRepository.findTotalNumber(); // 전체 광고 수를 조회하는 메서드

		if (totalNum > Integer.MAX_VALUE) {
			throw new Exception("totalNum exceeds Integer.MAX_VALUE in findAdsByPage");
		}
		int startIdx = totalNum.intValue() - unitNum * pageNum + 1;
		// startIdx가 유효한 범위 내에 있는지 확인
		if (startIdx < 0 || startIdx > totalNum.intValue()) {
			throw new Exception("Invalid start index in findAdsByPage");
		}
		int endIdx = Math.min(startIdx + unitNum - 1, totalNum.intValue());

		return adRepository.findAllWithPagination(startIdx, endIdx);
	}
}
