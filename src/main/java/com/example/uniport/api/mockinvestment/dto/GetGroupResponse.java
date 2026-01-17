package com.example.uniport.api.mockinvestment.dto;

import java.util.List;
import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetGroupResponse {
	private String id;
	private String name;
	private String topic;
	private int capacity;
	private List<UserBrief> members;
	private String status;
}

