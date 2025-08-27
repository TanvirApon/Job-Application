package com.example.jobapp.Jobs;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findJob(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Long id,Job job);
}
