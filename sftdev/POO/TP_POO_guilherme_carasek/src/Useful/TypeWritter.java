package Useful;

public class TypeWritter {

    /**
     * Types text in a more interesting way
     * @param message - to be printed
     * @param speed - of print
     */
    public static void type(String message, int speed) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(speed);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * Types text at a determined speed.
     * @param text - to be printed.
     */
    public static void type(String text) {
        type(text, 25);
    }
}
