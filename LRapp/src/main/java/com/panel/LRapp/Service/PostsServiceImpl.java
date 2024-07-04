package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.PostsDTO;
import com.panel.LRapp.Dto.post;
import com.panel.LRapp.Dto.postContent;
import com.panel.LRapp.Entity.Posts;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Repo.PostsRepo;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.response.PostList;
import com.panel.LRapp.response.PostResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService{
    @Autowired
    private PostsRepo postsRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public PostResponse getPostById(int id) {

        if (postsRepo.findById(id).isEmpty()){
            return new PostResponse("لم يتم العثور على هذا التعليق :(", null);
        }

        else{
            return new PostResponse(" تم العثور على التعليق بنجاح :)", postsRepo.findById(id).get());
        }
    }

    @Override
    public PostList findAll() {
        return new PostList(postsRepo.findAll());
    }

    @Override
    public PostResponse createNewPost(post postDto, String token) {

        Token t= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(t.getUser().getEmail());

        Posts p=new Posts(postDto.getContent(),0,0, user.getName(), user.getImage(),false,false);
        p.setUser(user);

        return new PostResponse("تمت الاضافه بنجاح :)",postsRepo.save(p));
    }

    @Override
    public PostResponse update(PostsDTO postDto) {

        Optional<Posts> p=postsRepo.findById(postDto.getId());

            p.get().setDisLike(postDto.getDisLike());
            p.get().setLike(postDto.getLike());
            p.get().setUserLiked(postDto.isUserLiked());
            p.get().setUserDisLiked(postDto.isUserDisLiked());


        return new PostResponse("نم التعديل بنجاح :)",postsRepo.save(p.get()));
    }

    @Override
    public PostResponse updateContent(postContent postDto) {

        Optional<Posts> p=postsRepo.findById(postDto.getId());

        p.get().setContent(postDto.getContent());


        return new PostResponse("نم التعديل بنجاح :)",postsRepo.save(p.get()));
    }
    @Transactional
    @Override
    public String delete(int id,String token) {

        String tokenValue = token.substring(7);
        Token t = tokenRepository.findByToken(tokenValue);

        if (t == null || t.getUser() == null) {
            return "Invalid token";
        }

        User user = userRepo.findByEmail(t.getUser().getEmail());
        Optional<Posts> optionalPost = postsRepo.findById(id);

        if (optionalPost.isEmpty()) {
            return "لم يتم العثور على هذا التعليق :(";
        }

        Posts post = optionalPost.get();

        if (!post.getUser().equals(user)) {
            return "User not authorized to delete this post";
        }

        user.getPosts().remove(post);

        postsRepo.delete(post);
        return "تم الحذف بنجاح :)";
    }

//    @Override
//    public PostResponse updateLike(PostsDTO postDto) {
//        return null;
//    }
//
//    @Override
//    public PostResponse updateDisLike(PostsDTO postDto) {
//        return null;
//    }
}
