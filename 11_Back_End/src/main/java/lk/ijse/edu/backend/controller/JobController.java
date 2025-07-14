package lk.ijse.edu.backend.controller;

import lk.ijse.edu.backend.dto.JobDTO;
import lk.ijse.edu.backend.service.JobService;
import lk.ijse.edu.backend.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("create")
//    public String createJob(@RequestBody JobDTO jobDTO) {
//        jobService.saveJob(jobDTO);
//        return "Job created successfully!";
//    }

    @PostMapping("create")
    public ResponseEntity<APIResponse<String>> createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return new ResponseEntity<>(new APIResponse<>(201, "Job created successfully!", "Success"
        ), HttpStatus.CREATED);
    }

//    @PutMapping("update")
//    public String updateJob(@RequestBody JobDTO jobDTO) {
//        jobService.updateJob(jobDTO);
//        return "Job updated successfully!";
//    }

    @PutMapping("update")
    public ResponseEntity<APIResponse<String>> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return ResponseEntity.ok(new APIResponse<>(200, "Job updated successfully!", "Success"));
    }

//    @PutMapping(value = "delete", params = "id")
//    public String deleteJob(@RequestParam("id") int id) {
//        jobService.deleteJob(id);
//        return "Job deleted successfully!";
//    }

    @PutMapping(value = "delete", params = "id")
    public ResponseEntity<APIResponse<String>> deleteJob(@RequestParam("id") int id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok(new APIResponse<>(200, "Job deleted successfully!", "Success"));
    }

//    @GetMapping("getalljobs")
//    public List<JobDTO> getAllJobs(){
//        return jobService.getAllJobs();
//    }

    @GetMapping("getalljobs")
    public ResponseEntity<APIResponse<List<JobDTO>>> getAllJobs(){
        List<JobDTO> jobDTOS = jobService.getAllJobs();
        return ResponseEntity.ok(new APIResponse<>(200, "Job Fatched Successfully", jobDTOS));
    }

//    @PatchMapping("/changeStatus/{id}")
//    public String changeJobStatus(@PathVariable("id") String id) {
//        jobService.changeJobStatus(id);
//        return "Job status changed successfully!";
//    }

    @PatchMapping("/changeStatus/{id}")
    public ResponseEntity<APIResponse<String>> changeJobStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
        return ResponseEntity.ok(new APIResponse<>(200, "Job status changed successfully!", "Success"));
    }

//    @GetMapping("search/{keyword}")
//    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword) {
//        return jobService.getAllJobsByKeyword(keyword);
//    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse<List<JobDTO>>> searchJob(@PathVariable("keyword") String keyword) {
        List<JobDTO> jobDTOS = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(new APIResponse<>(200, "Job Search Results", jobDTOS));
    }
}
