import java.util.Map;

public class LogIn {
    private String email = "";
    private String password = "";

    private void getEnvironmentVariables(){
        Map<String, String> env = System.getenv();
        setEmail(env.get("LOGIN_PART_ONE"));
        setPassword(env.get("LOGIN_PART_TWO"));
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        //Map<String,String> env = System.getenv();
        //return env.get("LOGIN_PART_ONE");
        return email;
    }

    public String getPassword() {
        //Map<String,String> env = System.getenv();
        //return env.get("LOGIN_PART_TWO");

        return password;
    }

    //"LOGIN_PART_TWO"
}