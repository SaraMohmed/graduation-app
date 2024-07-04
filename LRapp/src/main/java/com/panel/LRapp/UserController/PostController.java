package com.panel.LRapp.UserController;


import com.panel.LRapp.Dto.PostsDTO;
import com.panel.LRapp.Dto.post;
import com.panel.LRapp.Dto.postContent;
import com.panel.LRapp.Entity.Posts;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Service.PostsService;
import com.panel.LRapp.response.PostList;
import com.panel.LRapp.response.PostResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostsService postsService;

    @PostMapping("/create")
    public PostResponse createNewPost(@RequestBody post postDto, @RequestHeader("Authorization") String t)  {
        return postsService.createNewPost(postDto,t);
    }
    @PutMapping("/update")
    public PostResponse updatePost(@RequestBody PostsDTO postDto){
        return postsService.update(postDto);
    }

    @PutMapping("/updateContent")
    public PostResponse updatePostContent(@RequestBody postContent postDto){
        return postsService.updateContent(postDto);
    }

    @DeleteMapping("/delete")
    public String deletePost(@RequestParam("id") int id,@RequestHeader("Authorization") String t){
        return postsService.delete(id,t);
    }

    @GetMapping("/getPost")
    public PostResponse getPostById(@RequestParam("id") int id){
        return postsService.getPostById(id);
    }

    @GetMapping("/getAllPosts")
    public PostList findAllPosts(){
        return postsService.findAll();
    }
}
