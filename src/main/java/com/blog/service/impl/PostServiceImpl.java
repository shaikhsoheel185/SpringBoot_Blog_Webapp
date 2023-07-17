package com.blog.service.impl;

import com.blog.dto.PostDto;
import com.blog.entity.Post;
import com.blog.mapper.PostMapper;
import com.blog.repositry.PostRepository;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {

        List<Post> posts = postRepository.findAll();

        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {

        Post post = PostMapper.mapToPost(postDto);
        postRepository.save(post);


    }

    @Override
    public PostDto findPostById(Long postId) {
        Post post = postRepository.findById(postId).get();
        return PostMapper.mapToPostDto(post);

    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public void deletePostByid(Long postId) {

        postRepository.deleteById(postId);

    }

    @Override
    public PostDto findPostBuUrl(String postUrl) {

        Post post = postRepository.findByUrl(postUrl).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);

        return posts.stream().
                map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }
}
