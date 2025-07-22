package lk.ijse.edu.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/21/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String accessToken;
}
