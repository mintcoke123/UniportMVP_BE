package com.example.uniport.api.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CursorPageParams {
	private String cursor;
	private Integer limit;
}

