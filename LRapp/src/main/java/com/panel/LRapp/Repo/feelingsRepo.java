package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Entity.feelings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface feelingsRepo extends JpaRepository<feelings,Integer> {
    @Query("SELECT f FROM feelings f WHERE f.name LIKE %?1%"
            + " OR f.description LIKE %?1%")
    List<feelings> findByName(String name);
}
