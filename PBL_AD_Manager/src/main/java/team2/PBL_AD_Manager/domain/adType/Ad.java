package team2.PBL_AD_Manager.domain.adType;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.Contracts;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
@Setter
public abstract class Ad {
	@Id
	@GeneratedValue
	@Column(name = "ad_id")
	private Long id;

	private long size;

	private long width;

	private long height;

	private String topText;

	private String bottomText;

	private String url;

	private int clickCount;

	private int price;

	@OneToOne(mappedBy = "ad")
	private Contracts contracts;
}
