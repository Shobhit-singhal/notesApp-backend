package com.shobhit.Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "postedBy",cascade = CascadeType.ALL)
    List<Note> notes=new ArrayList<>();

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    private List<ToDo> todos=new ArrayList<>();
}
