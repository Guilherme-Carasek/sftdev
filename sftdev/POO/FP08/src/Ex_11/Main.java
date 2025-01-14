package Ex_11;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta("123456", "Joaquim");

        conta1.depositar(1000);
        conta1.mostrarSaldo();
        conta1.levantar(120);
        conta1.mostrarSaldo();

        Conta conta2 = new Conta("987654", "Joana");
        Conta conta3 = new Conta("345167", "Jorge");

        conta1.transferencia(440, conta2);
        conta1.transferencia(440, conta3);

        System.out.println("_________");
        conta1.mostrarSaldo();
        conta2.mostrarSaldo();
        conta3.mostrarSaldo();
    }
}
