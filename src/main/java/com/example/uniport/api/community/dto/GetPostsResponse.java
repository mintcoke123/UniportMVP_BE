package com.example.uniport.api.community.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetPostsResponse {
	private List<PostListItemDto> items;
	private String nextCursor;
}

