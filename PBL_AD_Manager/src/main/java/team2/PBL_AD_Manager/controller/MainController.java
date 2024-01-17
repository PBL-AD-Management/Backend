package team2.PBL_AD_Manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Contracts;
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
	public String getAdApi(Model model) {
		model.addAttribute("ads", adService.findAds());
		model.addAttribute("adForm", new AdForm());
		return "main";
	}

	@PostMapping("/contract/create")
	public String create(AdForm adForm) {
		Contracts contracts = new Contracts();

		adForm.getAge();
		adForm.getName();
		adForm.getPrice();
		adForm.getGender();
		adForm.getTitle();
		adForm.getSlotPosition();
		adForm.getStartDate();
		adForm.getEndDate();
		return "/";
	}
}
