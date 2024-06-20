package org.example.finalexambackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String resultType;
    private LocalDate resultDate;
    private String resultValue;

    @ManyToOne
    @JoinColumn(name = "athlete_id_fk")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "discipline_id_fk")
    private Discipline discipline;

}
