package Rooms;

import Entities.Heros.Hero;

public class BossRoom extends Room{
    @Override
    public String describe() {
        return "BOSS TIME";
    }

    @Override
    public boolean enter(Hero hero, int step) {
        //TODO
        return true;
    }
}
