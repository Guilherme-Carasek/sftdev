package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GuestControllerTest {

    private GuestController guestController;
    private GuestController guestControllerControl;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.guestController = new GuestController("src/test/resources/Cesaeland_atracoes.csv");
        this.guestControllerControl = new GuestController("src/test/resources/Cesaeland_atracoes_control.csv");
    }

    @Test
    public void getListOfAttractionsTest() {
        assertEquals(11, guestController.getListOfAttractions().size());
        assertEquals(12, guestControllerControl.getListOfAttractions().size());
    }
}