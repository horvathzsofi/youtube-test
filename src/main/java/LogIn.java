import java.util.Map;

public class LogIn {
    private final String email = System.getenv("LOGIN_PART_ONE");
    private final String password = System.getenv("LOGIN_PART_TWO");

    public String getEmail() {
    //    Map<String,String> env = System.getenv();
      //  return env.get("LOGIN_PART_ONE");
        return email;
    }

    public String getPassword() {
      //  Map<String,String> env = System.getenv();
      //  return env.get("LOGIN_PART_TWO");
        return password;
    }
}
