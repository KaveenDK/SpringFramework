package lk.ijse.edu.backend.service;

import lk.ijse.edu.backend.dto.JobDTO;

import java.util.List;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/7/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

public interface JobService {
    void saveJob(JobDTO jobDTO);
    void updateJob(JobDTO jobDTO);
    void deleteJob(int id);
    List<JobDTO> getAllJobs();
    void changeJobStatus(String id);
    List<JobDTO> getAllJobsByKeyword(String keyword);
}
