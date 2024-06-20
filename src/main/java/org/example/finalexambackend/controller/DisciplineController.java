package org.example.finalexambackend.controller;

import org.example.finalexambackend.dto.AthleteDto;
import org.example.finalexambackend.dto.DisciplineDto;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Discipline;
import org.example.finalexambackend.repository.DisciplineRepository;
import org.example.finalexambackend.service.DisciplineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    DisciplineService disciplineService;

    //Get all disciplines
    @GetMapping("")
    public List<DisciplineDto> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    //Get disciplines based on id
    @GetMapping("/{id}")
    public DisciplineDto getDisciplinesById(@PathVariable int id) {
        return disciplineService.getDisciplineById(id);
    }

    //Post discipline to database
    @PostMapping("")
    public Discipline addDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.createDiscipline(discipline);
    }

    //Update discipline in database
    @PutMapping("/{id}")
    public Discipline updateDiscipline(@PathVariable int id, @RequestBody Discipline discipline) {
        return disciplineService.updateDiscipline(id, discipline);
    }

    //Delete discipline in database
    @DeleteMapping("/{id}")
    public String deleteAthlete(@PathVariable int id) {
        disciplineService.deleteDiscipline(id);
        return "Discipline with ID: " + id + " has been deleted";
    }
}
