package Rooms;

import Entities.Heros.Hero;

public abstract class Room {

    /**
     * Returns a String description to be shown before entering the room.
     * @return
     */
    public abstract String describe();

    /**
     *
     * @param hero
     * @param step
     * @return true if hero is alive.
     */
    public abstract boolean enter(Hero hero, int step);
}
