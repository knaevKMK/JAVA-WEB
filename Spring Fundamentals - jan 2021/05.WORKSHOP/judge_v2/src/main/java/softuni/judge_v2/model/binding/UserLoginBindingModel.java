package softuni.judge_v2.model.binding;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
@Setter
public class UserLoginBindingModel {

    @Length(min = 2, message = "Username must be minimum 2 characters")
    private String username;

    @Length(min = 3, message = "Password must be minimum 3 characters")
    private String password;

}
