package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.SlidesEntity;
import com.laptrinhjavaweb.model.dto.SlidesDto;


@Component
public class SlidesConverter {
	public SlidesDto toModel (SlidesEntity slidesEntity) {
		SlidesDto slidesModel = new SlidesDto();
		slidesModel.setId(slidesEntity.getId());
		slidesModel.setCaption(slidesEntity.getCaption());
		slidesModel.setContent(slidesEntity.getContent());
		slidesModel.setImg(slidesEntity.getImg());
		return slidesModel;
	}
}
