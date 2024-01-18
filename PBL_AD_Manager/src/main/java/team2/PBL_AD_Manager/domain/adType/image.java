package team2.PBL_AD_Manager.domain.adType;

import jakarta.persistence.Entity;

@Entity
public class Image extends Ad {
	public static Image createImage(String url, int price, String text) {
		Image imageAd = new Image();
		imageAd.setUrl(url);
		imageAd.setPrice(price);
		imageAd.setText(text);

		return imageAd;
	}
}
