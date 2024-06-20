package org.example.finalexambackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean gender;
    private LocalDate birthdate;
    private String club;

    @ManyToMany
    @JoinTable(
            name = "athlete_discipline",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id")
    )
    private Set<Discipline> disciplines;

    @OneToMany(mappedBy = "athlete")
    private Set<Result> results;

}
