package Ex_02;

import Ex_02.tacos.TacoCarne;
import Ex_02.tacos.TacoFrango;
import Ex_02.tacos.TacoVegetariano;

public class Cozinha {

    static public Taco fazerTaco(String tipo){
        switch (tipo){
            default: return null;
            case "carne":
                return new TacoCarne();
            case "frango":
                return new TacoFrango();
            case "vegetariano":
                return new TacoVegetariano();
        }
    }
}
