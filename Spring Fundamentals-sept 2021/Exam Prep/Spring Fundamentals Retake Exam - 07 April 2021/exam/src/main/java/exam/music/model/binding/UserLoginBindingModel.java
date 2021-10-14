package exam.music.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }
    @NotNull(message = "Username required")
    @Length( min=3,max = 20,message = "Username length must between 3 and 20 symbols")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotNull(message = "Password required")
    @Length( min=3,message = "Password length must be more than 3")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
