import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogInTest {
    //private LogIn logIn = null;

    @BeforeAll
    public void SetUp(){
        Login logIn = new LogIn();
    }

    @Test
    public void TestGetEmail(){
        String email = logIn.getEmail();
        Assertions.assertEquals("sajt", email);
    }
    @Test
    public void TestGetPassword(){
        String password = logIn.getPassword();
        Assertions.assertEquals("alma", password);
    }
}
