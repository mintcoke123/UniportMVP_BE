package com.example.uniport.api.mockinvestment.service;

import com.example.uniport.api.mockinvestment.dto.CreateGroupRequest;
import com.example.uniport.api.mockinvestment.dto.CreateGroupResponse;
import com.example.uniport.api.mockinvestment.dto.CreateMessageRequest;
import com.example.uniport.api.mockinvestment.dto.CreateMessageResponse;
import com.example.uniport.api.mockinvestment.dto.GetGroupResponse;
import com.example.uniport.api.mockinvestment.dto.GetGroupsResponse;
import com.example.uniport.api.mockinvestment.dto.GetMessagesResponse;
import com.example.uniport.api.mockinvestment.dto.JoinGroupResponse;
import com.example.uniport.api.mockinvestment.dto.LeaveGroupResponse;
import com.example.uniport.api.mockinvestment.dto.MatchRequest;
import com.example.uniport.api.mockinvestment.dto.MatchResponse;

public interface MockInvestmentService {
    GetGroupsResponse listGroups(String status, String cursor, Integer limit);
    CreateGroupResponse createGroup(CreateGroupRequest request);
    JoinGroupResponse joinGroup(String groupId);
    LeaveGroupResponse leaveGroup(String groupId);
    GetGroupResponse getGroup(String groupId);
    MatchResponse match(MatchRequest request);
    GetMessagesResponse listMessages(String groupId, String since, Integer limit);
    CreateMessageResponse createMessage(String groupId, CreateMessageRequest request);
}

