package org.example.finalexambackend.dto;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Discipline;
import org.example.finalexambackend.entity.Result;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class DisciplineDto {
    private int id;
    private String name;
    private String resultType;


public DisciplineDto(Discipline d) {
    this.id = d.getId();
    this.name = d.getName();
    this.resultType = d.getResultType();
}
}