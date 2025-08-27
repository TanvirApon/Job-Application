package com.example.jobapp.Jobs.impl;

import com.example.jobapp.Jobs.Job;
import com.example.jobapp.Jobs.JobRepository;
import com.example.jobapp.Jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplement implements JobService {
      //  List<Job> jobs = new ArrayList<>();
     JobRepository jobRepository;
     //   private Long nextId = 1L;

    public JobServiceImplement(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
      //   return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        //jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job findJob(Long id) {
        /*
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;*/

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        /*
        for (Job job:jobs) {
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;*/

        /*
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;*/
        try{
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
       /*
        for(Job job:jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;*/

        Optional<Job> jobOptional = jobRepository.findById(id);
         if(jobOptional.isPresent()){
             Job job = jobOptional.get();
             job.setTitle(updatedJob.getTitle());
             job.setDescription(updatedJob.getDescription());
             job.setMaxSalary(updatedJob.getMaxSalary());
             job.setMinSalary(updatedJob.getMinSalary());
             job.setLocation(updatedJob.getLocation());
             jobRepository.save(job);
             return true;
         }
        return false;
    }

}
