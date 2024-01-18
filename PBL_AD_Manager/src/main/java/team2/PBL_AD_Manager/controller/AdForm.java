package team2.PBL_AD_Manager.controller;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdForm {

	private String title;

	private int age;

	private int price;

	private String url;

	private String content;

	private LocalDateTime endDate;

}
