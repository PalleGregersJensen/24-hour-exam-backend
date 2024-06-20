package org.example.finalexambackend.controller;

import org.example.finalexambackend.dto.AthleteDto;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/athletes")
public class AthleteController {

    @Autowired
    AthleteService athleteService;

    //Get all athletes
    @GetMapping("")
    public List<AthleteDto> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    //Get athletes based on id
    @GetMapping("/{id}")
    public AthleteDto getAthletesById(@PathVariable int id) {
        return athleteService.getAthleteById(id);
    }

    //Post athlete to database
    @PostMapping("")
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        return athleteService.createAthlete(athlete);
    }

    //Update athlete in database
    @PutMapping("/{id}")
    public Athlete updateAthlete(@PathVariable int id, @RequestBody Athlete athlete) {
        return athleteService.updateAthlete(id, athlete);
    }

    //Delete athlete in database
    @DeleteMapping("/{id}")
    public String deleteAthlete(@PathVariable int id) {
        athleteService.deleteAthlete(id);
        return "Athlete with ID: " + id + " has been deleted";
    }
}
