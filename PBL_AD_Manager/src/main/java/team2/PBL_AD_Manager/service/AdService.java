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
}
