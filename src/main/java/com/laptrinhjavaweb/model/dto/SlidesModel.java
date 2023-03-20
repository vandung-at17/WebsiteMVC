package com.laptrinhjavaweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlidesModel {
	private Long id;
	private String img;
	private String caption;
	private String content;
}
