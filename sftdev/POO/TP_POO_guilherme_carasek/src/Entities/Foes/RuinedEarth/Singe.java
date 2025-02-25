package Entities.Foes.RuinedEarth;

import Entities.Foes.Boss;

public class Singe extends Boss {
    public Singe(int step) {
        super(step);
        this.name = "Singe";
    }

    @Override
    public String greet() {
        return "An enormous root dragon soars in the sky and lands in your path. You cannot run from it";
    }

    @Override
    public String talk(int counter) {
        switch (counter){
            default: return "...";
            case 1: return "The dragon has a thick and scaly skin made of dried roots, but you can see a small patch \n" +
                    "of flesh in it's chest. You have to try and land a shot on this spot.";
        }
    }
}
