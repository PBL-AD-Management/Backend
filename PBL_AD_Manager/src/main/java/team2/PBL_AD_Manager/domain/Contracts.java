package team2.PBL_AD_Manager.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.adType.Ad;

@Entity
@Getter
@Setter
public class Contracts {
	@Id
	@GeneratedValue
	@Column(name = "contract_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "advertiser_id")
	private Advertiser advertiser;

	private int price;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	@Enumerated(EnumType.STRING)
	private SlotPosition slotPosition;

	@OneToOne
	@JoinColumn(name = "ad_id")
	private Ad ad;

	@OneToOne
	private TargetInf targetInf;

	public void setAd(Ad ad) {
		this.ad = ad;
		ad.setContracts(this);
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
		advertiser.getContracts().add(this);
	}

	public static Contracts createContracts(int price, SlotPosition slotPosition, Ad ad, TargetInf targetInf,
		Advertiser advertiser) {
		Contracts contracts = new Contracts();
		contracts.setPrice(price);
		contracts.setSlotPosition(slotPosition);
		contracts.setTargetInf(targetInf);
		contracts.setAd(ad);
		contracts.setAdvertiser(advertiser);
		return contracts;
	}
}
