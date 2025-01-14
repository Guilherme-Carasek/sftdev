package Ex_02;

public class Conta {
    private String numero;
    private double saldo = 0;
    private String titular;
    private int anoAbertura = 2023;
    private double margemEmprestimo = 0.9;
    private double valorDivida = 0;

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

    public boolean pedirEmprestimo ( double valor ){
        if ( this.valorDivida == 0 && (this.margemEmprestimo*this.saldo) >= valor ){
            this.saldo += valor;
            this.valorDivida += valor;
            return true;
        }
        else return false;
    }
}
