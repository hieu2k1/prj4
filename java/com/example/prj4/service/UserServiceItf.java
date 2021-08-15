package com.example.prj4.service;

import com.example.iasf.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserServiceItf {
    UserEntity createUser(UserEntity p);
    List<UserEntity> getAll();
    void deleteUser(int id);
    Optional<UserEntity> findUserById(int id);
    List<UserEntity> getUserByName(String username, Pageable pageable);
    List<UserEntity> getAllProduct(Pageable pageable);
    Page<UserEntity> findAll(Pageable pageable);
}
