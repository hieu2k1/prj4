package com.example.prj4.repository;

import com.example.prj4.entity.PostEntity;
import com.example.prj4.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity,Integer> {

    @Query("select p from PostEntity p where p.namepost like %:namepost%")
    List<PostEntity> findAllByName(String name, Pageable pageable);

}
