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
    private LocalDate date;
    private String resultValue;
    private Athlete athlete;
    private Discipline discipline;

    public ResultDto(Result r) {
        this.id = r.getId();
        this.resultType = r.getResultType();
        this.date = r.getDate();
        this.resultValue = r.getResultValue();
        this.athlete = r.getAthlete();
        this.discipline = r.getDiscipline();
    }

}
