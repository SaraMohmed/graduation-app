package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    void deleteById(int id);

    Optional<User> findById(int id);

    List<User> findAll();


}
