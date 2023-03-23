package com.laptrinhjavaweb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginateResponse {
	private int page;//currentPage
	private Integer totalPage;// Tổng số Page
	private int start;
	private int end;
}
