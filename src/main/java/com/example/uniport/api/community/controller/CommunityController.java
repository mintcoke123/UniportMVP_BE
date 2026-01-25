package com.example.uniport.api.community.controller;

import com.example.uniport.api.common.dto.CursorPageParams;
import com.example.uniport.api.community.dto.CreateCommentRequest;
import com.example.uniport.api.community.dto.CreateCommentResponse;
import com.example.uniport.api.community.dto.CreatePostRequest;
import com.example.uniport.api.community.dto.CreatePostResponse;
import com.example.uniport.api.community.dto.GetCommentsResponse;
import com.example.uniport.api.community.dto.GetPostResponse;
import com.example.uniport.api.community.dto.GetPostsResponse;
import com.example.uniport.api.community.dto.UpdatePostRequest;
import com.example.uniport.api.community.dto.UpdatePostResponse;
import com.example.uniport.api.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/community/posts")
    public GetPostsResponse listPosts(@ModelAttribute CursorPageParams page,
                                      @RequestParam(required = false) String search,
                                      @RequestParam(required = false) String tag) {
        return communityService.listPosts(search, tag, page.getCursor(), page.getLimit());
    }

    @PostMapping("/community/posts")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest request) {
        CreatePostResponse response = communityService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/community/posts/{id}")
    public GetPostResponse getPost(@PathVariable String id) {
        return communityService.getPost(id);
    }

    @PatchMapping("/community/posts/{id}")
    public UpdatePostResponse updatePost(@PathVariable String id, @RequestBody UpdatePostRequest request) {
        return communityService.updatePost(id, request);
    }

    @DeleteMapping("/community/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        communityService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/community/posts/{id}/comments")
    public GetCommentsResponse listComments(@PathVariable String id) {
        return communityService.listComments(id);
    }

    @PostMapping("/community/posts/{id}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable String id,
                                                               @RequestBody CreateCommentRequest request) {
        CreateCommentResponse response = communityService.createComment(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

