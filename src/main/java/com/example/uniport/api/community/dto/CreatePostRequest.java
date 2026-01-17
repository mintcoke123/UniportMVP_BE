package com.example.uniport.api.community.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePostRequest {
	private String title;
	private String content;
	private List<String> tags;
}

