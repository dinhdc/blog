package com.blog.service;

import com.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    CommentDto getCommentById(long postId, long commentId);
    CommentDto updateComment(long postId, long commentId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    void deleteComment(long postId, long commentId);
}
