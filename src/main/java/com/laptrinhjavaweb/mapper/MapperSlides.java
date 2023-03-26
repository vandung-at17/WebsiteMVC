package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.laptrinhjavaweb.model.dto.SlidesDto;



public class MapperSlides implements RowMapper<SlidesDto>{

	@Override
	public SlidesDto mapRow(ResultSet rs, int rowNum)  {
		// TODO Auto-generated method stub
		try {
			SlidesDto slidesModel = new SlidesDto();
			slidesModel.setId(rs.getLong("id"));
			slidesModel.setImg(rs.getString("img"));
			slidesModel.setCaption(rs.getString("caption"));
			slidesModel.setContent(rs.getString("content"));
			return slidesModel;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Lỗi ở phần MapperSlides");
			return null;
		}
	}

}
