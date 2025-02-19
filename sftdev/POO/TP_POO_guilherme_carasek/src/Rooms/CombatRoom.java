package Rooms;

import Entities.Foes.Foe;
import Entities.Foes.RuinedEarth.Hulk;
import Entities.Foes.RuinedEarth.RootBrute;
import Entities.Foes.RuinedEarth.Stalker;
import Entities.Heros.Hero;

import java.util.Random;
import java.util.Scanner;

public class CombatRoom extends Room{


    @Override
    public String describe() {
        return "A ruined city of a past time";
    }

    /**
     * Returns true if hero is alive.
     */
    @Override
    public boolean enter(Hero hero, int step) {
        Foe foe = generateFoe(step);
        System.out.println(foe.greet());

        Scanner in = new Scanner(System.in);

        int choice = -1;

            while (choice != 3){
                System.out.println("You need to make a decision:");
                System.out.println("1. Interact");
                System.out.println("2. Fight");
                System.out.println("3. Run");

                if ( in.hasNextInt() ) choice = in.nextInt();

                int counter = 0;
                switch (choice){
                    default : break;
                    case 1:
                        System.out.println(foe.talk(++counter));
                        break;
                    case 2: return hero.fight(foe);
                    case 3: return true;
                }
            }
        return true;
    }

    /**
     * Creates an enemy for this room based on the number of steps of the game.
     * @param step
     * @return
     */
    protected Foe generateFoe(int step){
        Random rnd = new Random();
        int randomFoe = rnd.nextInt(1,4);
        switch (randomFoe){
            default: return null;
            case 1:
                return new Hulk(step);
            case 2:
                return new RootBrute(step);
            case 3:
                return new Stalker(step);
        }
    }
}
