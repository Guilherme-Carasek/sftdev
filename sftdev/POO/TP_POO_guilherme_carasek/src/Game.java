import Entities.Heros.ExCultist;
import Entities.Heros.Hero;
import Entities.Heros.Hunter;
import Entities.Heros.Scrapper;
import Rooms.*;
import Useful.TypeWritter;

import java.util.Random;
import java.util.Scanner;

public class Game {


    /**
     * Starts a new game, from character construction until character perishes.
     */
    public static void start(){
        TypeWritter.type("  _____                 _                   _     _____  _____   _____ \n" +
                " |  __ \\               (_)                 | |   |  __ \\|  __ \\ / ____|\n" +
                " | |__) |   _ _ __ ___  _ _ __   __ _ _ __ | |_  | |__) | |__) | |  __ \n" +
                " |  _  / | | | '_ ` _ \\| | '_ \\ / _` | '_ \\| __| |  _  /|  ___/| | |_ |\n" +
                " | | \\ \\ |_| | | | | | | | | | | (_| | | | | |_  | | \\ \\| |    | |__| |\n" +
                " |_|  \\_\\__,_|_| |_| |_|_|_| |_|\\__,_|_| |_|\\__| |_|  \\_\\_|     \\_____|", 5);


        TypeWritter.type("You wake up. \nThe wind blows strong, heavy rain drops fall on your drenched body.");
        TypeWritter.type("The storm has brought you to a shore, your raft destroyed.");
        TypeWritter.type("Who are you? You try very hard to remember.");
        TypeWritter.type("Type in your name:");

        Scanner in = new Scanner(System.in);
        String name = in.next();
//        in = new Scanner(System.in);

        int statsGiven = 0, choice = 0;
        while (choice < 1 || choice > 2){
            TypeWritter.type("Are you an experienced adventurer?");
            TypeWritter.type("1. You have survived many struggles in the past, nothing scares you.");
            TypeWritter.type("2. You still have much to learn.");
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

            //If step == 10 its boss time!
            if (step % 10 == 0) {
                BossRoom bossRoom = new BossRoom();
                bossRoom.enter(hero, step++);
            }
            if (hero.getCurrentHp() < 1) return;

            TypeWritter.type("You must choose a path.");
            Room[] rooms = new Room[2];
            for (int i = 0; i < 2; i++){
                Random rnd = new Random();
                int roomSelect = rnd.nextInt(5);
                switch (roomSelect){
                    case 0, 1, 2:
                        CombatRoom combatRoom = new CombatRoom();
                        TypeWritter.type((i+1) + ". " + combatRoom.describe());
                        rooms[i] = combatRoom;
                        break;
                    case 3:
                        VendorRoom vendorRoom = new VendorRoom();
                        TypeWritter.type((i+1) + ". " + vendorRoom.describe());
                        rooms[i] = vendorRoom;
                        break;
                    case 4:
                        TreasureRoom treasureRoom = new TreasureRoom();
                        TypeWritter.type((i+1) + ". " + treasureRoom.describe());
                        rooms[i] = treasureRoom;
                        break;
                }
            }
            int roomchoice = -1;
            while (roomchoice < 0 || roomchoice > 1){
                if(in.hasNextInt()) roomchoice = in.nextInt()-1;
                if (roomchoice == 0 || roomchoice == 1){
                    isAlive = rooms[roomchoice].enter(hero, step++);
                }
            }
        }
    }


    public static Hero chooseClass(int statsGiven, String name){
        TypeWritter.type("There is a gun strapped to your back.");

        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > 3){
            TypeWritter.type("What kind of weapon is this?");
            TypeWritter.type("1. A Coach Gun.");
            TypeWritter.type("2. A Hunting Rifle.");
            TypeWritter.type("3. A Shotgun.");
            if (in.hasNextInt()) choice = in.nextInt();
            switch (choice){
                case 1:
                    ExCultist exCultist = new ExCultist(name, statsGiven);
                    return exCultist;
                case 2:
                    return new Hunter(name, statsGiven);
                case 3:
                    return new Scrapper(name, statsGiven);
            }
        }
        return new ExCultist(name, statsGiven);
    }
}
