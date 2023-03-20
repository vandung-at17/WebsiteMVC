package com.laptrinhjavaweb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginateResponse {
	private Integer page;
	private Integer totalPage;
}
