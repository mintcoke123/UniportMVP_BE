package com.example.uniport.api.mockinvestment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateGroupRequest {
	private String name;
	private String topic;
	private int capacity;
}

