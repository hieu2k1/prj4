package com.example.prj4.repository;

import com.example.prj4.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);


    @Query("select p from UserEntity p where p.username like %:username%")
    List<UserEntity> findAllByName(String username, Pageable pageable);

//    Page<UserEntity> findAllByNameContaining(String firstname, Pageable pageable);
}
