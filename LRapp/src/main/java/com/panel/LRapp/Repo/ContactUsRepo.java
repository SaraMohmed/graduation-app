package com.panel.LRapp.Repo;


import com.panel.LRapp.Entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs,Integer> {
}
