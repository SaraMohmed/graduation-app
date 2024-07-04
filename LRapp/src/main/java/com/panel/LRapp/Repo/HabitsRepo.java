package com.panel.LRapp.Repo;

import com.panel.LRapp.Entity.Habits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface HabitsRepo extends JpaRepository<Habits, Integer> {


//    @Query( "SELECT f FROM Habits f WHERE f.title LIKE %?1%")
//    List<Habits> searchByName(String name);
}
