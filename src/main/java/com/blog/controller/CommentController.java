package com.blog.controller;

import com.blog.dto.CommentDto;
import com.blog.dto.PostDto;
import com.blog.service.CommentService;
import com.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private CommentService commentService;
    private PostService postService;



    public CommentController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }


    // handler method to create form submit request
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @Valid
                                @ModelAttribute("comment")CommentDto commentDto,
                                BindingResult result,
                                Model model){

        PostDto postDto = postService.findPostBuUrl(postUrl);

        if (result.hasErrors()){
            model.addAttribute("comment", commentDto);
            model.addAttribute("post", postDto);
            return "blog/blog_post";
        }

        commentService.createComment(postUrl, commentDto);
        return "redirect:/post/"+ postUrl;
    }
}
