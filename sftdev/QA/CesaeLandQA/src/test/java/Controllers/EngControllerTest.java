package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EngControllerTest {

    private EngController engController;
    private EngController engControllerControl;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.engController = new EngController(
                "src/test/resources/Cesaeland_atracoes.csv",
                "src/test/resources/Cesaeland_vendas.csv"
                );
        this.engControllerControl = new EngController(
                "src/test/resources/Cesaeland_atracoes_control.csv",
                "src/test/resources/Cesaeland_vendas_control.csv"
        );
    }

    @Test
    public void getNextMaintenancesTest() {
        // 4* atraction 3, 3* atraction 5, 2* atraction 9
        assertEquals("3", engController.getNextMaintenances()[0][0]);
        assertEquals("5", engController.getNextMaintenances()[1][0]);
        assertEquals("9", engController.getNextMaintenances()[2][0]);

        // attraction 4 should be the next
        assertEquals("4", engControllerControl.getNextMaintenances()[0][0]);
    }
}