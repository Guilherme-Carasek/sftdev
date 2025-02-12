package Rooms;

import Entities.Heros.Hero;

public abstract class Room {

    /**
     * Returns a String description to be shown before entering the room.
     * @return
     */
    public abstract String describe();

    public abstract void enter(Hero hero, int step);
}
