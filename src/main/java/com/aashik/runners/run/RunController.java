package com.aashik.runners.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void Create(@Valid @RequestBody Run run){
        runRepository.Create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void Update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.Update(run, id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void Delete(@PathVariable Integer id){
        runRepository.Delete(id);
    }
}
