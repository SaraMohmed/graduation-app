package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.UserChallengePrivate;
import com.panel.LRapp.Entity.UserChallengePublic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UCPublicRepo extends JpaRepository<UserChallengePublic,Integer> {
    @Query("SELECT f FROM UserChallengePublic f WHERE f.name LIKE %?1%"
            + " OR f.description LIKE %?1%")
    List<UserChallengePublic> findByName(String name);
}
