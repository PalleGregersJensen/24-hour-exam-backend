package org.example.finalexambackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String resultType;

    @ManyToMany(mappedBy = "disciplines")
    private Set<Athlete> athletes;

    @OneToMany(mappedBy = "discipline")
    private Set<Result> results;

}
