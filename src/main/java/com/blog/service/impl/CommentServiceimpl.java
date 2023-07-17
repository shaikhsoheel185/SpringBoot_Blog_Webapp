package com.blog.service.impl;

import com.blog.dto.CommentDto;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.mapper.CommentMapper;
import com.blog.repositry.CommentRepository;
import com.blog.repositry.PostRepository;
import com.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceimpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceimpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Post post =postRepository.findByUrl(postUrl).get();
         Comment comment =CommentMapper.mapToComment(commentDto);
         comment.setPost(post);
         commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
       List<Comment> comments = commentRepository.findAll();
       return comments.stream()
               .map(CommentMapper::mapToCommentDto)
               .collect(Collectors.toList());

    }

    @Override
    public void deleteComment(Long commentId) {

        commentRepository.deleteById(commentId);
    }
}
