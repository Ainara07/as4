package com.example.cinema.model.dto;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String movieName;
    private String showTime;
    private int price;
    private int hall;
}
