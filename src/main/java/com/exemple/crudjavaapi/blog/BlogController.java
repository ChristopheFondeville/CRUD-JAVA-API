package com.exemple.crudjavaapi.blog;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table (name = "blog")
public class BlogController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String content;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private Blob image;
}
