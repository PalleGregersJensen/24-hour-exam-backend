package org.example.finalexambackend.controller;

import org.example.finalexambackend.dto.ResultDto;
import org.example.finalexambackend.entity.Result;
import org.example.finalexambackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/results")
public class ResultController {

    @Autowired
    ResultService resultService;

    //Get all results
    @GetMapping("")
    public List<ResultDto> getAllResults() {
        return resultService.getAllResults();
    }

    //Get result based on id
    @GetMapping("/{id}")
    public ResultDto getResultsById(@PathVariable int id) {
        return resultService.getResultById(id);
    }

    //Post result to database
    @PostMapping("")
    public Result addResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    //Update result in database
    @PutMapping("/{id}")
    public Result updateResult(@PathVariable int id, @RequestBody Result result) {
        return resultService.updateResult(id, result);
    }

    //Delete result in database
    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable int id) {
        resultService.deleteResult(id);
        return "result with ID: " + id + " has been deleted";
    }

}
