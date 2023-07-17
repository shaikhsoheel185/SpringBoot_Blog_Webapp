package com.blog.service;

import com.blog.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> findAllPosts();
    public void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePostByid( Long postId);

    PostDto findPostBuUrl(String postUrl);

    List<PostDto> searchPosts(String query);
}
