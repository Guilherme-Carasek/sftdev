package Entities.Foes.RuinedEarth;

import Entities.Foes.Fighter;

public class Hulk extends Fighter {
    public Hulk(int step){
        super(step);
        this.name = "Hulk";
    }

    @Override
    public String greet() {
        return "You see a creature dragging a giant sword as it walks. \n" +
                "You try to stay quiet, but it still notices you.\n" +
                "The hulking thing builds up a mighty charge.";
    }

    @Override
    public String talk(int counter) {
        switch (counter){
            default: return "...";
            case 1: return "Hulks... I seen these monsters tear through barricades like they were made of paper. " +
                    "\nThey don’t give a damn about bullets or pain or anything but charging headlong and smashing " +
                    "\neverything within reach. When I was a kid, I thought the Hulks were the worst thing the Root " +
                    "could throw at us.\n" +
                    "Oh, I was wrong though.";
        }
    }
}
