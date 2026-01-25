package com.example.uniport.api.community.service;

import com.example.uniport.api.community.dto.CreateCommentRequest;
import com.example.uniport.api.community.dto.CreateCommentResponse;
import com.example.uniport.api.community.dto.CreatePostRequest;
import com.example.uniport.api.community.dto.CreatePostResponse;
import com.example.uniport.api.community.dto.GetCommentsResponse;
import com.example.uniport.api.community.dto.GetPostResponse;
import com.example.uniport.api.community.dto.GetPostsResponse;
import com.example.uniport.api.community.dto.UpdatePostRequest;
import com.example.uniport.api.community.dto.UpdatePostResponse;

public interface CommunityService {
    GetPostsResponse listPosts(String search, String tag, String cursor, Integer limit);
    CreatePostResponse createPost(CreatePostRequest request);
    GetPostResponse getPost(String postId);
    UpdatePostResponse updatePost(String postId, UpdatePostRequest request);
    void deletePost(String postId);

    GetCommentsResponse listComments(String postId);
    CreateCommentResponse createComment(String postId, CreateCommentRequest request);
}

