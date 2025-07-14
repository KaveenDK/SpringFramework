package lk.ijse.edu.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/7/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDTO {
    private int id;
    @NotBlank(message = "Job Title is required")
    private String jobTitle;
    @NotBlank(message = "Company Name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Company Name should contain only alphabets")
    private String company;
//    @Email(message = "Please provide a valid email")
    private String location;
    @NotBlank(message = "Job Type is required")
    private String type;
    @Size(min = 10, message = "Job Description should be at least 10 characters long")
    private String jobDescription;
    private String status;
}
