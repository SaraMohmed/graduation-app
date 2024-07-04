package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.PostsDTO;
import com.panel.LRapp.Dto.post;
import com.panel.LRapp.Dto.postContent;
import com.panel.LRapp.Entity.Posts;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.response.PostList;
import com.panel.LRapp.response.PostResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface PostsService {
    PostResponse getPostById(int id);
    PostList findAll();

    PostResponse createNewPost(post postDto, String t);

    PostResponse update(PostsDTO postDto);

    PostResponse updateContent(postContent postDto);

    String delete(int id, String t);
//    PostResponse updateLike(PostsDTO postDto);
//    PostResponse updateDisLike(PostsDTO postDto);
}
