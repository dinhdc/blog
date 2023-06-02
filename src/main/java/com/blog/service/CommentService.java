package com.blog.service;

import com.blog.entity.Comment;
import com.blog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
}
