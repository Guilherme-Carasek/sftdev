package Entities.Foes.RuinedEarth;

import Entities.Foes.Assassin;

public class Stalker extends Assassin {
    public Stalker(int step) {
        super(step);
    }

    @Override
    public String greet() {
        return "You feel a presence behind you. But you made sure the path was cleared, right?";
    }

    @Override
    public String talk(int counter) {
        switch (counter){
            default : return null;
            case 1 : return "You remember a survivor's account:\n " +
                    "\"Others don’t believe me, but I swear it’s true—there’s a deadwood what can go invisible. " +
                    "The shadowy thing stalked us for miles, waiting until one of us split off. I saw Noella " +
                    "get jumped out of nowhere, her life sucked away one breath at a time before I could get my gun. " +
                    "Damn thing got away.\n" +
                    "Noella... she didn’t.\"";
        }
    }
}
