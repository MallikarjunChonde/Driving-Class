package com.arjun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjun.dto.UserRequestDTO;
import com.arjun.dto.UserResponseDTO;
import com.arjun.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    User Adding method
    
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = convertToEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return convertToResponseDTO(savedUser);
    }

//  Get All user method  
    
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return convertToResponseDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userRequestDTO.getName());
        existingUser.setEmail(userRequestDTO.getEmail());
        existingUser.setPhoneNumber(userRequestDTO.getPhoneNumber());
        existingUser.setScheduledTime(userRequestDTO.getScheduledTime());
        existingUser.setProgress(userRequestDTO.getProgress());
        existingUser.setRole(userRequestDTO.getRole());
        User updatedUser = userRepository.save(existingUser);
        return convertToResponseDTO(updatedUser);
    }

    private User convertToEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        user.setScheduledTime(dto.getScheduledTime());
        user.setProgress(dto.getProgress());
        user.setRole(dto.getRole());
        return user;
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getScheduledTime(),
                user.getProgress(),
                user.getRole().name()
        );
    }
    
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
}