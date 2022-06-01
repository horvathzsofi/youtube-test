import java.util.Map;

public class LogIn {
    private String email = "";
    private String password = "";

    public LogIn() {
        getEnvironmentVariables();
    }

    private void getEnvironmentVariables() {
        Map<String, String> env = System.getenv();
        email = env.get("LOGIN_PART_ONE");
        password = env.get("LOGIN_PART_TWO");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}