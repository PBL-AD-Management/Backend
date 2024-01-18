package team2.PBL_AD_Manager.domain.adType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Video extends Ad {
	private Long playTime;

	public static Video createVideo(String url, int price, String text) {
		Video VideoAd = new Video();
		VideoAd.setUrl(url);
		VideoAd.setPrice(price);
		VideoAd.setText(text);

		return VideoAd;
	}
}
