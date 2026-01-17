package com.example.uniport.api.mockinvestment.dto;

import java.util.List;
import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LeaveGroupResponse {
	private String id;
	private List<UserBrief> members;
}

