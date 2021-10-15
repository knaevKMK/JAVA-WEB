package exam.music.model.view;

public class UserViewModel {
    private String username;
    private String email;
    private String country;
    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
