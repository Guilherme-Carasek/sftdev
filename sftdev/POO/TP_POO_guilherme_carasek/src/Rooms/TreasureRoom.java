package Rooms;

import Entities.Heros.Hero;

import java.util.Random;
import java.util.Scanner;

public class TreasureRoom extends Room{
    @Override
    public String describe() {
        return "A bright red shimmer catches your attention, what's behind the next corner?";
    }

    @Override
    public boolean enter(Hero hero, int step) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("There is a giant red crystal floating in the air...");
        System.out.println("You feel strangely safe around it, should you trust this feeling?");
        System.out.println("1. Approach the crystal and sit next to it");
        System.out.println("2. Leave");
        int choice = -1;
        if (in.hasNextInt()) choice = in.nextInt();
        if (choice != 1) return true;

        System.out.println("You watch as the crystal slowly turns in the air, it soothes your mind");
        System.out.println("The light reflects off of an object left near it, is that a book?");
        System.out.println("1. Read the book");
        System.out.println("2. Leave");

        choice = -1;
        int randomNumber = rnd.nextInt(3,10);
        if (in.hasNextInt()) choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println("You open the book on a random page");
                System.out.println(this.generatePage());
                break;
            case 2:
                break;
        }
        if (choice == randomNumber) {
            System.out.println("You fount a hidden treasure!");
            int scrapFound = 100 + step * 10;
            hero.gainScrap(scrapFound);
            System.out.println("+" + scrapFound + " scrap");
            return true;
        }
        System.out.println("There was a small amount of scrap next to the book.");
        System.out.println("You take the scrap and leave");
        int scrapFound = step * 10;
        System.out.println("+" + scrapFound + " scrap");
        return true;
    }

    private String generatePage() {
        Random rnd = new Random();
        int randomPage = rnd.nextInt(5);
        switch (randomPage){
            case 0:
                return "The Root invasion was swift and devastating and, although the world’s armed forces mounted a valiant defense,\n " +
                        "they were overwhelmed in time. Civilization was cast into ruin and mankind was driven nearly to extinction.\n " +
                        "It’s been a few decades since the initial invasion and the world is in a state of decay. \n" +
                        "The environment reflects the chaos of that time – debris-ridden streets and gutted buildings set against \n" +
                        "a backdrop of broken skyscrapers. Beneath the city sprawls a network of broken subway tunnels and rancid sewage corridors.";
            case 1:
                return "Humans are like roaches. It would take a lot to eradicate a species that’s as adaptable as man. \n" +
                        "The Root invasion nearly wiped out the human race but some survived and were either driven underground or into hiding. \n" +
                        "Human groups exist all over the world in loose tribes, who’ve either forgotten or actively shun technology, \n" +
                        "or in organized camps that are trying to rebuild a fragment of what was once lost. The most prominent hub, however, \n" +
                        "is Ward 16. Inside that fortified complex lives a small but capable group of survivors who are actively trying to learn \n" +
                        "from past mistakes and discover a way to drive the Root from Earth once and for all.";
            case 2:
                return "Many believe Ward 13 was built as a safeguard against a final World War that never came. \n" +
                        "Others believe that it was a research facility where new weapons were being developed. \n" +
                        "Neither could be further from the truth. A few unfortunate souls know the real reason Ward 13 was built – \n" +
                        "to house and study the World Stones. A number of Wards were built across the planet and a small shard \n" +
                        "of the original World Stone was sent to each one for further study. This lead to the discovery \n" +
                        "of the portals to other worlds… and the attention of  the Root.  During the invasion, the Wards became \n" +
                        "a haven for a few select people. The facility’s thick walls kept them safe even as the rest of the world fell to the invaders. \n" +
                        "As time passed, some Wards survived while others were lost.  The few desperate survivors of Ward 13 \n" +
                        "are all that remains of a once-larger community.";
            case 3:
                return "This page is written in a weird language you've never seen before";
            case 4:
                return "This page was destroyed";
        }
return null;
    }
}
