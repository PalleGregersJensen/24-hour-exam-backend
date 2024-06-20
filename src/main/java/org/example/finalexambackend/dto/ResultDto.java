package org.example.finalexambackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Discipline;
import org.example.finalexambackend.entity.Result;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto {
    private int id;
    private String resultType;
    private LocalDate resultDate;
    private String resultValue;
    private int athleteId;
    private String athleteFirstname;
    private String athleteLastName;
    private int disciplineId;
    private String disciplineName;

    public ResultDto(Result r) {
        this.id = r.getId();
        this.resultType = r.getResultType();
        this.resultDate = r.getResultDate();
        this.resultValue = r.getResultValue();
        this.athleteId = r.getAthlete().getId();
        this.athleteFirstname = r.getAthlete().getFirstname();
        this.athleteLastName = r.getAthlete().getLastname();
        this.disciplineId = r.getAthlete().getId();
        this.disciplineName = r.getDiscipline().getName();
    }

}
