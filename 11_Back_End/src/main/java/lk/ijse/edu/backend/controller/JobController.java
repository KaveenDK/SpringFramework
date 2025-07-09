package lk.ijse.edu.backend.controller;

import lk.ijse.edu.backend.dto.JobDTO;
import lk.ijse.edu.backend.service.JobService;
import lk.ijse.edu.backend.service.impl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
public class JobController {

    private final JobService jobService;

    @PostMapping("create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job created successfully!";
    }

    @PutMapping("update")
    public String updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return "Job updated successfully!";
    }

    @PutMapping(value = "delete", params = "id")
    public String deleteJob(@RequestParam("id") int id) {
        jobService.deleteJob(id);
        return "Job deleted successfully!";
    }

    @GetMapping("getalljobs")
    public List<JobDTO> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PatchMapping("/changeStatus/{id}")
    public String changeJobStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
        return "Job status changed successfully!";
    }

    @GetMapping("search/{keyword}")
    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }

}
