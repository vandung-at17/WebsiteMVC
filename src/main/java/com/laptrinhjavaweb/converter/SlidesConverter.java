package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.SlidesEntity;
import com.laptrinhjavaweb.model.dto.SlidesModel;


@Component
public class SlidesConverter {
	public SlidesModel toModel (SlidesEntity slidesEntity) {
		SlidesModel slidesModel = new SlidesModel();
		slidesModel.setId(slidesEntity.getId());
		slidesModel.setCaption(slidesModel.getCaption());
		slidesModel.setContent(slidesEntity.getContent());
		slidesModel.setImg(slidesEntity.getImg());
		return slidesModel;
	}
}
