package Entities.Foes.RuinedEarth;

import Entities.Foes.Tank;

public class RootBrute extends Tank {

    public RootBrute(int step) {
        super(step);
        this.name = "Root Brute";
    }

    @Override
    public String greet() {
        return "You hear heavy steps coming from the corner";
    }

    @Override
    public String talk(int counter) {
        switch (counter) {
            default : return null;
            case 1: return "Some survivors whispered about a kind of tank on two legs fused with some Root " +
                    "machine-gun the size of an oil drum. A Juggernaut. Damn thing could wipe out a city, they say," +
                    " if there were any cities left.\n" +
                    "They’re just whispers though. They gotta be…";
            case 2: return "It has a heavy metal plate on it's right shoulder. If I could just knock it off...";
        }
    }
}
