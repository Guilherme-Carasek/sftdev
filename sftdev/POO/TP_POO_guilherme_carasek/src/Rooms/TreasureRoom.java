package Rooms;

import Entities.Heros.Hero;

public class TreasureRoom extends Room{
    @Override
    public String describe() {
        return "A bright red shimmer catches your attention, what's behind the next corner?";
    }

    @Override
    public boolean enter(Hero hero, int step) {
        //TODO
        return true;
    }
}
