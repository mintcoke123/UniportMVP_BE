package com.example.uniport.api.mockinvestment.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetGroupsResponse {
	private List<GroupListItemDto> items;
	private String nextCursor;
}

