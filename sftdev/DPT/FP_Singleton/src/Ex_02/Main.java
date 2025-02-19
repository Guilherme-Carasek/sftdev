package Ex_02;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance("app_log.txt");
        logger.log("feito singleton logger");
        logger.log("testando singleton logger");
        logger.log("log3: algo aconteceu");
    }
}
