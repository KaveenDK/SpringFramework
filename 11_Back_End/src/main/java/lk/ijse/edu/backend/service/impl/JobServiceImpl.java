package lk.ijse.edu.backend.service.impl;

import lk.ijse.edu.backend.dto.JobDTO;
import lk.ijse.edu.backend.entity.Job;
import lk.ijse.edu.backend.exceptions.ResourceNotFound;
import lk.ijse.edu.backend.repository.JobRepository;
import lk.ijse.edu.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/7/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDTO jobDTO) {
//        Job job = new Job();
//        job.setJobTitle(jobDTO.getJobTitle());
//        job.setCompany(jobDTO.getCompany());
//        job.setLocation(jobDTO.getLocation());
//        job.setType(jobDTO.getType());
//        job.setJobDescription(jobDTO.getJobDescription());
//
//        jobRepository.save(job);

        if (jobDTO == null) {
            log.error("Job cannot be null");
            throw new IllegalArgumentException("Job cannot be null");
        }
        jobDTO.setId(0);
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        if (jobDTO==null||jobDTO.getId()==0){
            log.error("Job Id cannot be null or zero");
            throw new IllegalArgumentException("Job Id cannot be null");
        }
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void deleteJob(int id) {
        if (id <= 0) {
            log.error("Job Id must be greater than zero");
            throw new IllegalArgumentException("Job Id must be greater than zero");
        }

        if (!jobRepository.existsById(id)) {
            log.error("Job with ID {} not found", id);
            throw new ResourceNotFound("Job with ID " + id + " not found");
        }

        jobRepository.deleteById(id);
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs=jobRepository.findAll();
        if (allJobs.isEmpty()){
            log.error("No jobs found");
            throw new ResourceNotFound("No Job Found");
        }
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public void changeJobStatus(String id) {
        int jobId = Integer.parseInt(id);
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFound("Job with ID " + id + " not found"));

        String newStatus = "Active".equalsIgnoreCase(job.getStatus()) ? "Deactivated" : "Active";
        jobRepository.updateJobStatus(jobId, newStatus);
    }


    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        if (keyword==null){
            log.error("Keyword cannot be null");
            throw new IllegalArgumentException("Keyword cannot be null");
        }
        List<Job> allJobs = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        if (allJobs.isEmpty()){
            log.error("No jobs found for keyword: {}", keyword);
            throw new ResourceNotFound("No Job Found");
        }
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }
}
