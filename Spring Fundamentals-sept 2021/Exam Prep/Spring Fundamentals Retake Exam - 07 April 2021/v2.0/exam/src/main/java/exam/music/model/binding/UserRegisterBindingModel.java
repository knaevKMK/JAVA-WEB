package exam.music.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }
   @NotNull(message = "Username required")
    @Length(min = 3, max = 20, message = "Username must be between 5 and 20 characters")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull(message = "Last Name required")
    @Length(min = 3, max = 20, message = "Last Name must be more than 5 characters")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "Email required")
@Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
    @NotNull(message = "Password required")
    @Length(min = 3, message = "Password must be more than 3 characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        checkPassword();
        return this;
    }
    @NotNull(message = "Confirm Password and Password NOT MATCH")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        checkPassword();
        return this;
    }

    private void checkPassword() {
        if(this.password == null || this.confirmPassword == null){
            return;
        }else if(!this.password.equals(confirmPassword)){
            this.confirmPassword = null;
        }
    }
}
