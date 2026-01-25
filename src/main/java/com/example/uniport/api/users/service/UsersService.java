package com.example.uniport.api.users.service;

import com.example.uniport.api.users.dto.AdjustUserPointsRequest;
import com.example.uniport.api.users.dto.AdjustUserPointsResponse;
import com.example.uniport.api.users.dto.GetMyPointsResponse;
import com.example.uniport.api.users.dto.GetUserResponse;
import com.example.uniport.api.users.dto.UpdateMeRequest;
import com.example.uniport.api.users.dto.UpdateMeResponse;

public interface UsersService {
    GetUserResponse getUser(String userId);
    UpdateMeResponse updateMe(UpdateMeRequest request);
    GetMyPointsResponse getMyPoints();
    AdjustUserPointsResponse adjustUserPoints(String userId, AdjustUserPointsRequest request);
}

