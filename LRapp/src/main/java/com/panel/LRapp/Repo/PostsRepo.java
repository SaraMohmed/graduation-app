package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PostsRepo extends JpaRepository<Posts,Integer> {
}
