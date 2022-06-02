import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogInTest {
    private LogIn logIn = null;
    //LogIn logIn = new LogIn();
    
    @BeforeEach
    public void SetUp(){
        logIn = new LogIn();
    }
    
    @Disabled
    @Test
    public void TestGetEmail(){
        String email = logIn.getEmail();
        Assertions.assertEquals("sajt", email);
    }
    
    @Disabled
    @Test
    public void TestGetPassword(){
        String password = logIn.getPassword();
        Assertions.assertEquals("alma", password);
    }
}
