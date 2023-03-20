package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.SlidesConverter;
import com.laptrinhjavaweb.entity.SlidesEntity;
import com.laptrinhjavaweb.model.dto.SlidesModel;
import com.laptrinhjavaweb.repository.SlidesRepository;
import com.laptrinhjavaweb.service.ISlidesService;

@Service
public class SlidesService implements ISlidesService {

	@Autowired
	private SlidesRepository slidesRepository;

	@Autowired
	private SlidesConverter slidesConverter;
	
	@Override
	public List<SlidesModel> findAll() {
		// TODO Auto-generated method stub
		List<SlidesEntity> slidesEntities = slidesRepository.findAll();
		List<SlidesModel> slidesModels = new ArrayList<SlidesModel>();
		for (SlidesEntity slidesEntity : slidesEntities) {
			SlidesModel slidesModel = slidesConverter.toModel(slidesEntity);
			slidesModels.add(slidesModel);
		}
		return slidesModels;
	}
	
	
}
