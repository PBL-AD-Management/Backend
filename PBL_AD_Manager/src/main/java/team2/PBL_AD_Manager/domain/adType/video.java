package team2.PBL_AD_Manager.domain.adType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Video extends Ad {
	private Long playTime;
}
