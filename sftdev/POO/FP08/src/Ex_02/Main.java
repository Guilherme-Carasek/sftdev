package Ex_02;

public class Main {
    public static void main(String[] args){

        Cao popi = new Cao("Popi", "Dachshund");
        Cao susan = new Cao("Susan", "Indefinida");
        Cao sky = new Cao("Sky","Indefinida");

        popi.ladrar();
        susan.ladrar();
        sky.ladrar();

        susan.setLatido("woof woof!");
        sky.setLatido("ruff ruff");

        popi.ladrar();
        susan.ladrar();
        sky.ladrar(5);

    }
}
