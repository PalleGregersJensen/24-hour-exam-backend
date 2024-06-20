package org.example.finalexambackend.service;

import org.example.finalexambackend.dto.DisciplineDto;
import org.example.finalexambackend.entity.Discipline;
import org.example.finalexambackend.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    //Get all disciplines
    public List<DisciplineDto> getAllDisciplines() {
        List<Discipline> disciplineList = disciplineRepository.findAll();
        List<DisciplineDto> disciplineDtoList = new ArrayList<>();

        for (Discipline discipline : disciplineList) {
            disciplineDtoList.add(new DisciplineDto(discipline));
        }

        return disciplineDtoList;
    }

    //Get discipline by id
    public DisciplineDto getDisciplineById(int id) {
        Discipline discipline = disciplineRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Discipline not found"));
        return new DisciplineDto(discipline);
    }

    //Create discipline
    public Discipline createDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    //Delete discipline
    public void deleteDiscipline(int id) {
        disciplineRepository.deleteById(id);
    }

    //Update discipline
    public Discipline updateDiscipline(int id, Discipline updatedDiscipline) {

        Optional<Discipline> existingDisciplineOptional = disciplineRepository.findById(id);
        // Check if Discipline with that ID exists in database
        if (existingDisciplineOptional.isPresent()) {
            // If Discipline exists, update the rest of the properties
            Discipline existingDiscipline = existingDisciplineOptional.get();
            existingDiscipline.setName(updatedDiscipline.getName());
            existingDiscipline.setResultType(updatedDiscipline.getResultType());
            existingDiscipline.setAthletes(updatedDiscipline.getAthletes());
            existingDiscipline.setResults(updatedDiscipline.getResults());

            // Save updated discipline in database
            return disciplineRepository.save(existingDiscipline);
        } else {
            // If athlete does not exist in database, throw error
            throw new RuntimeException("Discipline with ID: " + id + " not found");
        }

    }
}
