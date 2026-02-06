package com.example.cinema.service;

import com.example.cinema.model.dto.UserDTO;
import java.util.List;


public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
}
