package main.com.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.com.myApp.validation.PasswordMatches;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class User {

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "Emai is required")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format"
    )
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    @Size(min = 8, message = "Confirm password must be at least 8 characters long")
    private String confirmPassword;
}
