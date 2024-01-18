package team2.PBL_AD_Manager.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Advertiser;
import team2.PBL_AD_Manager.domain.Contracts;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.SlotPosition;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.domain.adType.Image;
import team2.PBL_AD_Manager.repository.AdRepository;
import team2.PBL_AD_Manager.repository.AdvertiserRepository;
import team2.PBL_AD_Manager.repository.ContractsRepository;
import team2.PBL_AD_Manager.service.AdService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final AdvertiserRepository advertiserRepository;
	private final AdService adService;
	private final ContractsRepository contractsRepository;
	private final AdRepository adRepository;

	@Getter
	static class AdList {
		private List<Ad> adList = new ArrayList<>();
	}

	@GetMapping("/")
	public String getAdApi(Model model) {
		List<Advertiser> advertiserList = advertiserRepository.findAll();
		model.addAttribute("advertisers", advertiserList);

		model.addAttribute("ads", adService.findAds());
		model.addAttribute("adForm", new AdForm());
		return "main";
	}

	@PostMapping("/contract/create")
	public String create(@RequestParam("CompanyId") Long id, @RequestParam("Slot") String slot,
		@RequestParam("Gender") String inputGender,
		AdForm adForm) {
		Gender gender = (inputGender == "male") ? Gender.male : Gender.female;
		int age = adForm.getAge();
		int price = adForm.getPrice();
		String title = adForm.getTitle();
		String url = adForm.getUrl();
		String content = adForm.getContent();
		SlotPosition slotPosition = (slot == "top") ? SlotPosition.top : SlotPosition.bottom;
		String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String endDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Image imageAd = Image.createImage(url, price, content);
		adRepository.saveAd(imageAd);
		Advertiser advertiser = advertiserRepository.findAdvertiser(id);
		Contracts contracts = Contracts.createContracts(price, slotPosition, imageAd, 1L, advertiser, startDate,
			endDate);

		contractsRepository.saveContract(contracts);

		return "redirect:/";
	}

	@GetMapping("/hi/{pageNum}")
	public String pagination(@PathVariable("pageNum") int pageNum, Model model) throws Exception {
		List<Ad> adList = adService.findAdsByPage(pageNum);
		model.addAttribute("adList", adList);
		return "main";
	}
}
