package com.example.uniport.api.mockinvestment.controller;

import com.example.uniport.api.common.dto.CursorPageParams;
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
import com.example.uniport.api.mockinvestment.service.MockInvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MockInvestmentController {

    private final MockInvestmentService mockInvestmentService;

    @GetMapping("/mock-investment/groups")
    public GetGroupsResponse listGroups(@ModelAttribute CursorPageParams page,
                                        @RequestParam(defaultValue = "open") String status) {
        return mockInvestmentService.listGroups(status, page.getCursor(), page.getLimit());
    }

    @PostMapping("/mock-investment/groups")
    public ResponseEntity<CreateGroupResponse> createGroup(@RequestBody CreateGroupRequest request) {
        CreateGroupResponse response = mockInvestmentService.createGroup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/mock-investment/groups/{id}/join")
    public JoinGroupResponse joinGroup(@PathVariable String id) {
        return mockInvestmentService.joinGroup(id);
    }

    @PostMapping("/mock-investment/groups/{id}/leave")
    public LeaveGroupResponse leaveGroup(@PathVariable String id) {
        return mockInvestmentService.leaveGroup(id);
    }

    @GetMapping("/mock-investment/groups/{id}")
    public GetGroupResponse getGroup(@PathVariable String id) {
        return mockInvestmentService.getGroup(id);
    }

    @PostMapping("/mock-investment/match")
    public MatchResponse match(@RequestBody MatchRequest request) {
        return mockInvestmentService.match(request);
    }

    @GetMapping("/mock-investment/groups/{id}/messages")
    public GetMessagesResponse listMessages(@PathVariable String id,
                                            @RequestParam(required = false) String since,
                                            @RequestParam(required = false, defaultValue = "50") Integer limit) {
        return mockInvestmentService.listMessages(id, since, limit);
    }

    @PostMapping("/mock-investment/groups/{id}/messages")
    public ResponseEntity<CreateMessageResponse> createMessage(@PathVariable String id,
                                                               @RequestBody CreateMessageRequest request) {
        CreateMessageResponse response = mockInvestmentService.createMessage(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

