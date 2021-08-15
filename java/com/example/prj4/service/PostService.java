package com.example.prj4.service;

import com.example.prj4.entity.PostEntity;
import com.example.prj4.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostEntity createPost(PostEntity p);
    List<PostEntity> getAll();
    void deletePost(int id);
    Optional<PostEntity> findPostById(int id);
    List<PostEntity> getPostByName(String namepost, Pageable pageable);
    List<PostEntity> getAllPost(Pageable pageable);
    Page<PostEntity> findAll(Pageable pageable);
}
