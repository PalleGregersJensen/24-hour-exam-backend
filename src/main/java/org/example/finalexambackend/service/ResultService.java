package org.example.finalexambackend.service;

import org.example.finalexambackend.dto.AthleteDto;
import org.example.finalexambackend.dto.ResultDto;
import org.example.finalexambackend.entity.Athlete;
import org.example.finalexambackend.entity.Result;
import org.example.finalexambackend.repository.ResultRepository;
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
    ResultRepository resultRepository;

    //Get all results
    public List<ResultDto> getAllResults() {
        List<Result> resultList = resultRepository.findAll();
        List<ResultDto> resultDtoList = new ArrayList<>();

        for (Result result : resultList) {
            resultDtoList.add(new ResultDto(result));
        }

        return resultDtoList;
    }

    //Get result by id
    public ResultDto getResultById(int id) {
        Result result = resultRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found"));
        return new ResultDto(result);
    }

    //Create result
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    //Delete result
    public void deleteResult(int id) {
        resultRepository.deleteById(id);
    }

    //Update result
    public Result updateResult(int id, Result updatedResult) {

        Optional<Result> existingResultOptional = resultRepository.findById(id);
        // Check if result with that ID exists in database
        if (existingResultOptional.isPresent()) {
            // If result exists, update the rest of the properties
            Result existingResult = existingResultOptional.get();
            existingResult.setResultDate(updatedResult.getResultDate());
            existingResult.setResultType(updatedResult.getResultType());
            existingResult.setResultValue(updatedResult.getResultValue());
            existingResult.setAthlete(updatedResult.getAthlete());
            existingResult.setDiscipline(updatedResult.getDiscipline());

            // Save updated result in database
            return resultRepository.save(existingResult);
        } else {
            // If result does not exist in database, throw error
            throw new RuntimeException("Result with ID: " + id + " not found");
        }

    }

}