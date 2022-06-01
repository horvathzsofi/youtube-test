import java.util.Map;

public class LogIn {
    private final String email = System.getenv("LOGIN_PART_ONE");
    private final String password = System.getenv("LOGIN_PART_TWO");

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}