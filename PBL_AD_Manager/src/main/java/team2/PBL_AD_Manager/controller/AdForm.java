package team2.PBL_AD_Manager.controller;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.SlotPosition;

@Getter
@Setter
public class AdForm {
	private String name;

	private String title;

	private int age;

	private Gender gender;

	private SlotPosition slotPosition;

	private int price;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

}
