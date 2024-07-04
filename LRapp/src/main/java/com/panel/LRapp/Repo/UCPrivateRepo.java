package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.UserChallengePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UCPrivateRepo extends JpaRepository<UserChallengePrivate,Integer> {
    @Query("SELECT f FROM UserChallengePrivate f WHERE f.name LIKE %?1%"
            + " OR f.description LIKE %?1%")
    List<UserChallengePrivate> findByName(String name);
}
