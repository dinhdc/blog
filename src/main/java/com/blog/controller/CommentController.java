package com.blog.controller;

import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getComments(
            @PathVariable(name = "postId") long id) {
        return commentService.getCommentsByPostId(id);
    }

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(name = "postId") long id,
            @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getComments(
            @PathVariable(name = "postId") long id,
            @PathVariable(name = "commentId") long commentId
    ) {
        CommentDto commentDto = commentService.getCommentById(id, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(name = "postId") long id,
            @PathVariable(name = "commentId") long commentId,
            @Valid @RequestBody CommentDto commentDto
    ) {
        CommentDto comment = commentService.updateComment(id, commentId, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(name = "postId") long id,
            @PathVariable(name = "commentId") long commentId
    ) {
        commentService.deleteComment(id, commentId);
        return new ResponseEntity<>("Comment delete successfully", HttpStatus.OK);
    }
}
