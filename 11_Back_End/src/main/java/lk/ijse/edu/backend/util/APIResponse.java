package lk.ijse.edu.backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/14/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse<T> {
  private int status;
  private String message;
  private T data;
}
