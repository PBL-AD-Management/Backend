package team2.PBL_AD_Manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.controller.Form.AdForm;
import team2.PBL_AD_Manager.controller.Form.SearchForm;
import team2.PBL_AD_Manager.controller.Form.UserForm;
import team2.PBL_AD_Manager.domain.Advertiser;
import team2.PBL_AD_Manager.domain.Contracts;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.TargetInf;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.repository.AdRepository;
import team2.PBL_AD_Manager.service.AdService;
import team2.PBL_AD_Manager.service.AdvertiserService;
import team2.PBL_AD_Manager.service.TargetService;
import team2.PBL_AD_Manager.service.UserService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final AdvertiserService advertiserService;
	private final UserService userService;
	private final AdService adService;
	private final AdRepository adRepository;
	

	@GetMapping("/")
	public String accessPage() {
		return "redirect:/1";
	}

	@GetMapping("/{pageNum}")
	public String pagination(@PathVariable("pageNum") int pageNum, @ModelAttribute("searchForm")SearchForm searchForm, Model model) throws Exception {
		// adForm 객체를 모델에 추가
		AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성
		UserForm userForm = new UserForm();
		model.addAttribute("advertisers", advertiserService.findAdvertisers());
		model.addAttribute("adForm", adForm);
		model.addAttribute("users", userService.findUsers());
		model.addAttribute("userForm", userForm);
		model.addAttribute("searchForm", searchForm);

		if(adRepository.findTotalNumber(searchForm) != 0){
			model.addAttribute("totalNum", adRepository.findTotalNumber(searchForm));
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("ads", adService.findAdsByPage(pageNum,searchForm));
		}
		return "main";
	}

	@PostMapping("/contract/create")
	public String create(AdForm adForm, BindingResult result) {

 		adService.createAdContract(adForm);

		return "redirect:/";
	}

	@GetMapping("/detail/{adId}")
	public String ADdetail(@PathVariable("adId") Long adId, Model model) throws Exception {
		Ad ad = adRepository.findOne(adId);
		AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성

		// ad 객체로 contracts, target info 가져오기
		Contracts contract = ad.getContracts();
		Advertiser advertiser = contract.getAdvertiser();
		TargetInf targetInf = new TargetInf();
		int[] targetArr = targetInf.TargetToStr(contract.getTargetId());

		model.addAttribute("ad", ad);
		model.addAttribute("contract", contract);
		model.addAttribute("advertiser", advertiser);
		model.addAttribute("adForm", adForm);

		return "detail";
	}

	@PostMapping("/ad/edit")
	public String update(AdForm adForm) {

		adService.editAdContract(adForm);

		return "redirect:/";
	}

	@PostMapping("/ad/delete")
	public String delete(@RequestParam("adId") Long adId){

		adService.delete(adId);

		return "redirect:/";
	}

	@GetMapping(value = "/ad/test")
	public String adTest(@ModelAttribute("userForm") UserForm userForm, Model model){
		model.addAttribute("targetId", 1L);
		Ad targetAd = adService.findTargetAd(userForm, "top");
		model.addAttribute("targetTopAd", targetAd);
		model.addAttribute("targetBottomAd", adService.findTargetAd(userForm, "bottom"));

		adService.incAdCount(userForm.getAdId());

		return "adTest";
	}
}
