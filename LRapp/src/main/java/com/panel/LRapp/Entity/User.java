package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "user")
@ToString
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "userImage")
    private String image;

    public User(int id, String name, String email, String password, String phone, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User(int id,String name, String email, String password, String phone, Role role, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.image = image;
    }

    public User(String name, String email, String password, String phone, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }


    //user details

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "code_id")
    private code co;


//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JoinColumn(name = "image_id")
//    private ImageData imageData;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tasks> tasks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Habits> habits;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserChallengePrivate> userChallengePrivates;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserChallengePublic> userChallengePublics;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Posts> posts;


    @ManyToMany
    @JoinTable(
            name = "user_admin",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private List<AdminChallenge> adminChallengeSet;

    @ManyToMany
    @JoinTable(
            name = "user_feel",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "feel_id")
    )
    private Set<feelings> feelingsSet = new HashSet<>();

    public Set<feelings> getFeelingsSet() {
        return feelingsSet;
    }

    public void setFeelingsSet(Set<feelings> feelingsSet) {
        this.feelingsSet = feelingsSet;
    }

    public List<AdminChallenge> getAdminChallengeSet() {
        return adminChallengeSet;
    }

    public void setAdminChallengeSet(List<AdminChallenge> adminChallengeSet) {
        this.adminChallengeSet = adminChallengeSet;
    }

    public List<UserChallengePrivate> getUserChallengePrivates() {
        return userChallengePrivates;
    }


    public void setUserChallengePrivates(List<UserChallengePrivate> userChallengePrivates) {
        this.userChallengePrivates = userChallengePrivates;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<UserChallengePublic> getUserChallengePublics() {
        return userChallengePublics;
    }

    public void setUserChallengePublics(List<UserChallengePublic> userChallengePublics) {
        this.userChallengePublics = userChallengePublics;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public List<Habits> getHabits() {
        return habits;
    }

    public void setHabits(List<Habits> habits) {
        this.habits = habits;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

//    public ImageData getImageData() {
//        return imageData;
//    }
//
//    public void setImageData(ImageData imageData) {
//        this.imageData = imageData;
//    }

    public code getCo() {
        return co;
    }

    public void setCo(code co) {
        this.co = co;
    }

    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getConfirmPass() {
//        return confirmPass;
//    }
//
//    public void setConfirmPass(String confirmPass) {
//        this.confirmPass = confirmPass;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
