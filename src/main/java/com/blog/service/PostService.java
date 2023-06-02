package com.blog.service;

import com.blog.payload.PostDto;
import com.blog.payload.PostResponse;


public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int page, int perPage, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(long id, PostDto postDto);

    void deletePostById(long id);
}
