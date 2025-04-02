package Controllers;

import Domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    private AdminController adminController;
    private AdminController adminControllerControl;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        adminController = new AdminController("src/test/resources/Cesaeland_atracoes.csv",
                "src/test/resources/Cesaeland_vendas.csv",
                "src/test/resources/Cesaeland_custos.csv");
        adminControllerControl = new AdminController("src/test/resources/Cesaeland_atracoes_control.csv",
                "src/test/resources/Cesaeland_vendas_control.csv",
                "src/test/resources/Cesaeland_custos_control.csv");
    }

    @Test
    public void getBestDurationValueAttractionTest() {
        assertEquals(new Attraction(1, "Atração Incrível de Teste", 1, 0.5, 3600),
                adminController.getBestDurationValueAttraction());
        assertEquals(new Attraction(1, "Atração Incrível de Teste Control", 1, 0.5, 10000),
                adminControllerControl.getBestDurationValueAttraction());
    }

}