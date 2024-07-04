package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.feelings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface AdminCRepo extends JpaRepository<AdminChallenge,Integer> {
    @Query("SELECT f FROM AdminChallenge f WHERE f.name LIKE %?1%"
            + " OR f.description LIKE %?1%")
    List<AdminChallenge> findByName(String name);
}
