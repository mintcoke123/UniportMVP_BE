package com.example.uniport.api.mockinvestment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupListItemDto {
	private String id;
	private String name;
	private String topic;
	private int capacity;
	private int members;
	private String status;
}

