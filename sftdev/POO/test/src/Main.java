public class Main {
    public static void main(String[] args) {
        for (int step = 0; step<21; step++){
            int modTwenty = step % 20;
            double percent = modTwenty * 0.05;
            //returns a difficulty graph that multiplies values by 10 at step '0', and peaks by 50x at step 18.
            double scaleFactor = 50*(0.5*(Math.pow(2, -50 * Math.pow(percent-0.4, 4))) + 0.95*(Math.pow(2, -100 * Math.pow(percent-0.9, 2)))) * ((step/20)+1);
            int hp = 5;
            hp = (int) Math.round(hp * scaleFactor);
            System.out.print(hp + " | ");
        }
    }
}
