package com.example.fashionblog.entities;

import com.example.fashionblog.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class UserRole extends  BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
