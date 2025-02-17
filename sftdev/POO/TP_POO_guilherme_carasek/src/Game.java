import Entities.Heros.ExCultist;
import Entities.Heros.Hero;
import Entities.Heros.Hunter;
import Entities.Heros.Scrapper;
import Rooms.CombatRoom;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void start(){
        System.out.println("You wake up. \nThe wind blows strong, heavy rain drops fall on your drenched body.");
        System.out.println("The storm has brought you to a shore, your raft destroyed.");
        System.out.println("Who are you? You try very hard to remember.");
        System.out.println("Type in your name:");

        Scanner in = new Scanner(System.in);
        String name = in.next();
//        in = new Scanner(System.in);

        int statsGiven = 0, choice = 0;
        while (choice < 1 || choice > 2){
            System.out.println("Are you an experienced adventurer?");
            System.out.println("1. You have survived many struggles in the past, nothing scares you.");
            System.out.println("2. You still have much to learn.");
            if (in.hasNextInt()) choice = in.nextInt();
            switch (choice){
                case 1:
                    statsGiven = 15;
                    break;
                case 2:
                    statsGiven = 30;
                    break;
            }
        }

        Hero hero = chooseClass(statsGiven, name);

        boolean isAlive = true;
        int step = 0;
        while (isAlive){
            Random rnd = new Random();
            switch (rnd.nextInt(2)){
                case 0:
                    CombatRoom combatRoom = new CombatRoom();
                    isAlive = combatRoom.enter(hero, step++);
                case 1:
                    CombatRoom combatRoom2 = new CombatRoom();
                    isAlive = combatRoom2.enter(hero, step++);
            }
        }
    }


    public static Hero chooseClass(int statsGiven, String name){
        System.out.println("There is a gun strapped to your back.");

        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > 3){
            System.out.println("What kind of weapon is this?");
            System.out.println("1. A Coach Gun.");
            System.out.println("2. A Hunting Rifle.");
            System.out.println("3. A Shotgun.");
            if (in.hasNextInt()) choice = in.nextInt();
            switch (choice){
                case 1:
                    return new ExCultist(name, statsGiven);
                case 2:
                    return new Hunter(name, statsGiven);
                case 3:
                    return new Scrapper(name, statsGiven);
            }
        }
        return null;
    }
}
