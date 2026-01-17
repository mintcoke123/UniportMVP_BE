package com.example.uniport.api.mockinvestment.dto;

import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageItemDto {
	private String id;
	private UserBrief user;
	private String text;
	private String createdAt;
}

