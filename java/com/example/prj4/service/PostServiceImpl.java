package com.example.prj4.service;

import com.example.iasf.entity.PostEntity;
import com.example.iasf.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Override
    public PostEntity createPost(PostEntity p) {
        return postRepo.save(p);
    }

    @Override
    public List<PostEntity> getAll() {
        return postRepo.findAll();
    }

    @Override
    public void deletePost(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public Optional<PostEntity> findPostById(int id) {
        return postRepo.findById(id);
    }

    @Override
    public List<PostEntity> getPostByName(String namepost, Pageable pageable) {
        return postRepo.findAllByName(namepost,pageable);
    }


    @Override
    public List<PostEntity> getAllPost(Pageable pageable) {
        return postRepo.findAll(pageable).getContent();
    }

    @Override
    public Page<PostEntity> findAll(Pageable pageable) {
        return postRepo.findAll(pageable);
    }
}
