package com.arjun.model;

import com.arjun.enums.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String password; // To enable authentication
    private String scheduledTime; // e.g., "5-6 PM daily"
    private String progress; // Beginner, Intermediate, Advanced

    @Enumerated(EnumType.STRING)
    private Role role; // Role: ADMIN, DRIVER, USER

//    @OneToOne(mappedBy = "assignedUser")
//    private Driver assignedDriver;
}
