package com.example.cinema.model.entity;
import jakarta.persistence.*;
import lombok.*;
    @Entity
    @Table(name = "users")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String movieName;
        @Column(nullable = false)
        private String showTime;
        private int price;
        private int hall;
    }

