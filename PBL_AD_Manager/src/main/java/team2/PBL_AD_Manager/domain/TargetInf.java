package team2.PBL_AD_Manager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TargetInf {
	@Id
	@GeneratedValue
	@Column(name = "targetInf_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private int age;
}
