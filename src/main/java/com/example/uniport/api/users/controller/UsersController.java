package com.example.uniport.api.users.controller;

import com.example.uniport.api.users.dto.AdjustUserPointsRequest;
import com.example.uniport.api.users.dto.AdjustUserPointsResponse;
import com.example.uniport.api.users.dto.GetMyPointsResponse;
import com.example.uniport.api.users.dto.GetUserResponse;
import com.example.uniport.api.users.dto.UpdateMeRequest;
import com.example.uniport.api.users.dto.UpdateMeResponse;
import com.example.uniport.api.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/users/{id}")
    public GetUserResponse getUser(@PathVariable String id) {
        return usersService.getUser(id);
    }

    @PatchMapping("/users/me")
    public UpdateMeResponse updateMe(@RequestBody UpdateMeRequest request) {
        return usersService.updateMe(request);
    }

    @GetMapping("/users/me/points")
    public GetMyPointsResponse getMyPoints() {
        return usersService.getMyPoints();
    }

    @PostMapping("/users/{id}/points/adjust")
    public ResponseEntity<AdjustUserPointsResponse> adjustPoints(@PathVariable String id,
                                                                 @RequestBody AdjustUserPointsRequest request) {
        return ResponseEntity.ok(usersService.adjustUserPoints(id, request));
    }
}

