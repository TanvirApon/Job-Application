package com.example.jobapp.Jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJob(@PathVariable Long id){
       Job job = jobService.findJob(id);
       if(job !=null){
           return new ResponseEntity<>(job, HttpStatus.OK);
       }
       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
         boolean deleted = jobService.deleteJob(id);
         if(deleted){
             return new ResponseEntity<>("Job deleted Successfully", HttpStatus.OK);
         }
         return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean update = jobService.updateJob(id,updatedJob);
        if(update){
            return new ResponseEntity<>("Job updated Successfully", HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
