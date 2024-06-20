package org.example.finalexambackend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Discipline;
import org.example.finalexambackend.entity.Result;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AthleteDto {
    private int id;
    private String firstname;
    private String lastname;
    private boolean gender;
    private LocalDate birthdate;
    private String club;
    private Set<Discipline> disciplines;
    private Set<Result> results;

    public AthleteDto (Athlete a) {
        this.id = a.getId();
        this.firstname = a.getFirstname();
        this.lastname = a.getLastname();
        this.gender = a.isGender();
        this.birthdate = a.getBirthdate();
        this.club = a.getClub();
        this.disciplines = a.getDisciplines();
        this.results = a.getResults();
    }
}
