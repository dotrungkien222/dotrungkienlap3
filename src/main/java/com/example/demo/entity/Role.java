package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@ToString
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50, message = "Role must be between 2 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Role must not be empty")
    private String name;
    @Size(max = 250, message = "Description must be less than 250 characters")
    @Column(name = "description", length = 250)
    private String description;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
