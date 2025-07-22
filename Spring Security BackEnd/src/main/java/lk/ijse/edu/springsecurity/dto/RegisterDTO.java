package lk.ijse.edu.springsecurity.dto;

import lombok.Data;

/**
 * --------------------------------------------
 *
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/21/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String role; // ADMIN or USER
}
