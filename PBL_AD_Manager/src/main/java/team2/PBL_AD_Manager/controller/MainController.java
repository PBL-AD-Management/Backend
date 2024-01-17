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
import team2.PBL_AD_Manager.service.AdService;

@Controller
@RequiredArgsConstructor
public class MainController {
	@Getter
	static class AdList {
		private List<Ad> adList = new ArrayList<>();
	}

	private final AdService adService;

	@GetMapping("/")
	@ResponseBody
	public String getAdApi(@RequestParam("page") int page) {
		AdController.AdList adList = new AdController.AdList();
		List<Ad> ads = adService.findAds();
		adList.getAdList().addAll(ads);

		return "main";
	}
}
