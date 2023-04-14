package com.laptrinhjavaweb.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginateRequest {
	private Integer page;
	private Integer limit;
}
