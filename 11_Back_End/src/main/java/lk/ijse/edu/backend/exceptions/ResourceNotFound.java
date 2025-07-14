package lk.ijse.edu.backend.exceptions;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/14/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
