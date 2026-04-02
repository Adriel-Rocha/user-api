package com.adriel.user_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriel.user_api.dto.UserDTO;
import com.adriel.user_api.model.User;
import com.adriel.user_api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::maptoUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long userId) {
        User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found!"));

        return maptoUserDTO(user);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(mapToUser(userDTO));
        
        return maptoUserDTO(user);
    }

    public UserDTO delete(Long userID) {
        User user = userRepository.findById(userID)
                    .orElseThrow(() -> new RuntimeException("User not found!"));
        
        userRepository.delete(user);

        return maptoUserDTO(user);
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);

        return maptoUserDTO(user);
    }

    public List<UserDTO> findByUserName(String name) {
        return userRepository.findByUserNameContaining(name)
                .stream()
                .map(this::maptoUserDTO)
                .toList();
    }

    public UserDTO maptoUserDTO(User user) {

        return UserDTO.builder()
                .userName(user.getUserName())
                .cpf(user.getCpf())
                .adress(user.getAdress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .registrationDate(user.getRegistrationDate())
                .build();
    }

    public User mapToUser(UserDTO userDTO) {
        return User.builder()
            .userName(userDTO.getUserName())
            .cpf(userDTO.getCpf())
            .adress(userDTO.getAdress())
            .email(userDTO.getEmail())
            .phone(userDTO.getPhone())
            .registrationDate(userDTO.getRegistrationDate())
            .build();
    }
}
