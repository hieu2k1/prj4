package com.example.prj4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mabaiviet;

    @Column(name = "namepost")
    private String namepost;

    @Column(name = "timeupload")
    private String timeupload;

    @Column(name = "adminupload")
    private String adminupload;

    @Column(name = "noidung")
    private String noidung;



    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getMabaiviet() {
        return mabaiviet;
    }

    public void setMabaiviet(int mabaiviet) {
        this.mabaiviet = mabaiviet;
    }

    public String getNamepost() {
        return namepost;
    }

    public void setNamepost(String namepost) {
        this.namepost = namepost;
    }

    public String getTimeupload() {
        return timeupload;
    }

    public void setTimeupload(String timeupload) {
        this.timeupload = timeupload;
    }

    public String getAdminupload() {
        return adminupload;
    }

    public void setAdminupload(String adminupload) {
        this.adminupload = adminupload;
    }


}
