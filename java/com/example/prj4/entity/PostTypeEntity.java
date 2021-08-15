package com.example.prj4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class PostTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maloai;

    @Column(name = "name")
    private String name;


    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
