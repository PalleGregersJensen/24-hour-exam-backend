package org.example.finalexambackend.service;

import org.example.finalexambackend.dto.AthleteDto;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    AthleteRepository athleteRepository;

    //Get all athletes
    public List<AthleteDto> getAllAthletes() {
        List<Athlete> athleteList = athleteRepository.findAll();
        List<AthleteDto> athleteDtoList = new ArrayList<>();

        for (Athlete athlete : athleteList) {
            athleteDtoList.add(new AthleteDto(athlete));
        }

        return athleteDtoList;
    }

    //Get athlete by id
    public AthleteDto getAthleteById(int id) {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "color not found"));
        return new AthleteDto(athlete);
    }

    //Create athlete
    public Athlete createAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    //Delete athlete
    public void deleteAthlete(int id) {
        athleteRepository.deleteById(id);
    }

    //Update athlete
    public Athlete updateAthlete(int id, Athlete updatedAthlete) {

        Optional<Athlete> existingAthleteOptional = athleteRepository.findById(id);
        // Check if athlete with that ID exists in database
        if (existingAthleteOptional.isPresent()) {
            // If athlete exists, update the rest of the properties
            Athlete existingAthlete = existingAthleteOptional.get();
            existingAthlete.setName(updatedAthlete.getName());
            existingAthlete.setGender(updatedAthlete.isGender());
            existingAthlete.setBirthdate(updatedAthlete.getBirthdate());
            existingAthlete.setClub(updatedAthlete.getClub());
            existingAthlete.setDisciplines(updatedAthlete.getDisciplines());
            existingAthlete.setResults(updatedAthlete.getResults());

            // Save updated athlete in database
            return athleteRepository.save(existingAthlete);
        } else {
            // If athlete does not exist in database, throw error
            throw new RuntimeException("Athlete with ID: " + id + " not found");
        }


    }
