package com.example.cinema.service.impl;


import com.example.cinema.model.dto.UserDTO;
import com.example.cinema.model.entity.User;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {this.userRepository=userRepository; }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = User.builder()
                .movieName(dto.getMovieName())
                .showTime(dto.getShowTime())
                .price(dto.getPrice())
                .hall(dto.getHall())
                .build();
        user = userRepository.save(user);
        return mapToDTO(user);
    }
    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .movieName(user.getMovieName())
                .showTime(user.getShowTime())
                .price(user.getPrice())
                .hall(user.getHall())
                .build();
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setMovieName(dto.getMovieName());
        user.setShowTime(dto.getShowTime());
        user.setPrice(dto.getPrice());
        user.setHall(dto.getHall());

        user = userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

}
