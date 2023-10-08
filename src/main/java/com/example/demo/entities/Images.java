package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Lob
    @Column(columnDefinition = "LONGBYTE")
    private byte[] file;

    private LocalDateTime timestamp;
}