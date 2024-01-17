package team2.PBL_AD_Manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.domain.adType.Image;
import team2.PBL_AD_Manager.service.AdService;

@Controller
@RequiredArgsConstructor
public class AdController {
	@Getter
	static class AdList {
		private List<Ad> adList = new ArrayList<>();
	}

	private final AdService adService;

	@GetMapping("getAd")
	@ResponseBody
	public AdList getAdApi(@RequestParam("page") int page) {
		AdList adList = new AdList();
		adList.getAdList().addAll(adService.findAds());

		return adList;
	}

	@GetMapping("setAd")
	public String setAdApi() {
		Image image = new Image();
		image.setBottomText("BottomText 입니다");
		image.setSize(1L);
		image.setHeight(1L);
		image.setClickCount(100);
		image.setUrl("http://localhost3000");
		image.setTopText("TopText 입니다");

		adService.saveAd(image);

		return "main";
	}
}
