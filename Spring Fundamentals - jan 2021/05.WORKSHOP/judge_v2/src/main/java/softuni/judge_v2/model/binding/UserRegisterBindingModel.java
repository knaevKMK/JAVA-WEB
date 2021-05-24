package softuni.judge_v2.model.binding;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterBindingModel {

    @Length(min = 2, message = "Username must be minimum 2 characters")
    private String username;

    @Length(min = 3, message = "Password must be minimum 3 characters")
    private String password;


    private String confirmPassword;

    @Email(message = "Enter valid email address")
    private String email;

    @Pattern(regexp = "https\\/\\/github\\.com\\/.+", message = "Enter valid git address")
    private String git;
}
