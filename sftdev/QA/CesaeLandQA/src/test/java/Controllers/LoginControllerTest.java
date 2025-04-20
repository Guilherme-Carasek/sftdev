package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private LoginController loginController;
    private LoginController loginControllerControl;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.loginController = new LoginController("src/test/resources/Cesaeland_logins.csv");
        this.loginControllerControl = new LoginController("src/test/resources/Cesaeland_logins_control.csv");
    }

    @Test
    public void accessTypeTest(){
        assertEquals("ENG", loginController.accessType("manutencao", "cesaeland"));
        assertEquals("ADMIN", loginControllerControl.accessType("adminteste", "passteste"));
        assertEquals("ERROR", loginController.accessType("userErrado", "passErrada"));
    }
}