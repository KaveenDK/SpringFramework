package lk.ijse.edu.backend.service.impl;

import lk.ijse.edu.backend.dto.JobDTO;
import lk.ijse.edu.backend.entity.Job;
import lk.ijse.edu.backend.repository.JobRepository;
import lk.ijse.edu.backend.service.JobService;
import lombok.RequiredArgsConstructor;
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

        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs=jobRepository.findAll();
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public void changeJobStatus(String id) {
        int jobId = Integer.parseInt(id);
        Optional<Job> jobOpt = jobRepository.findById(jobId);
        if (jobOpt.isPresent()) {
            Job job = jobOpt.get();
            String newStatus = "Active".equalsIgnoreCase(job.getStatus()) ? "Deactivated" : "Active";
            jobRepository.updateJobStatus(jobId, newStatus);
        }
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        List<Job> allJobs = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }
}
