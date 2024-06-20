package org.example.finalexambackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Discipline;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AthleteDto {
    private int id;
    private String firstname;
    private String lastname;
    private boolean gender;
    private int age;
    private String club;
    private Set<Discipline> discipline;

    public AthleteDto(Athlete a) {
        this.id = a.getId();
        this.firstname = a.getFirstname();
        this.lastname = a.getLastname();
        this.gender = a.isGender();
        this.age = calculateAge(a.getBirthdate());
        this.club = a.getClub();
        this.discipline =a.getDisciplines();
    }

    private int calculateAge(LocalDate birthdate) {
        if (birthdate != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthdate, currentDate).getYears();
        }
        return 0; // Default value if birthdate is null
    }
}
