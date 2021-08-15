package com.example.prj4.service;

//import com.example.iasf.entity.TokenEntity;
import com.example.iasf.entity.UserEntity;
import com.example.iasf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceItf{

    @Autowired
    UserRepo userRepo;


    @Override
    public UserEntity createUser(UserEntity p) {
        return userRepo.save(p);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findUserById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public List<UserEntity> getUserByName(String username, Pageable pageable) {
        return userRepo.findAllByName(username, pageable);
    }

    @Override
    public List<UserEntity> getAllProduct(Pageable pageable) {
        return userRepo.findAll(pageable).getContent();
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }


}
