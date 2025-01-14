package Ex_11;

public class Conta {
    private String numero;
    private double saldo = 0;
    private String titular;

    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public void transferencia(double valor, Conta destinatario){
        if (this.saldo >= valor){
            this.saldo -= valor;
            destinatario.saldo += valor;
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void levantar(double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
        }
    }

    public void mostrarSaldo(){
        System.out.println("Saldo da conta: "+this.saldo +"EUR");
    }
}


