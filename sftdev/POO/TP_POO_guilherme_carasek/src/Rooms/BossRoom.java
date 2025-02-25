package Rooms;

import Entities.Foes.RuinedEarth.Singe;
import Entities.Heros.Hero;
import Itens.Equipable.Consumable.DragonHeart;

public class BossRoom extends Room{
    @Override
    public String describe() {
        return "BOSS TIME";
    }

    @Override
    public boolean enter(Hero hero, int step) {
        Singe boss = new Singe(step);
        System.out.println(boss.greet());

        boolean alive = hero.fight(boss);
        if (alive) hero.addItemToInventory(new DragonHeart(step+2));
        return alive;
    }


}
