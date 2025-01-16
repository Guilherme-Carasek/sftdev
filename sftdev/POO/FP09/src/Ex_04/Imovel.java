package Ex_04;

public class Imovel {
    private String rua;
    private int portaNumero;
    private String cidade;
    private TipoImovel tipo;
    private AcabamentoImovel acabamento;
    private double areaImovelMsqr;
    private int numeroQuartos;
    private int numeroCasasBanho;
    private double areaPiscinaMsqr;

    public Imovel(String rua, int portaNumero, String cidade, TipoImovel tipo, AcabamentoImovel acabamento, double areaImovelMsqr, int numeroQuartos, int numeroCasasBanho, double areaPiscinaMsqr) {
        this.rua = rua;
        this.portaNumero = portaNumero;
        this.cidade = cidade;
        this.tipo = tipo;
        this.acabamento = acabamento;
        this.areaImovelMsqr = areaImovelMsqr;
        this.numeroQuartos = numeroQuartos;
        this.numeroCasasBanho = numeroCasasBanho;
        this.areaPiscinaMsqr = areaPiscinaMsqr;
    }

    public double calcularValor(){
        double valorImovelEur = 0;
        if (this.tipo == TipoImovel.APARTAMENTO){
            valorImovelEur += areaImovelMsqr*1000;
        } else if (this.tipo == TipoImovel.CASA){
            valorImovelEur += areaImovelMsqr*3000;
        } else if (this.tipo == TipoImovel.MANSAO) {
            valorImovelEur += areaImovelMsqr*5000;
        }
        //__________________________
        valorImovelEur += numeroQuartos*7500;
        valorImovelEur += numeroCasasBanho*10500;
        valorImovelEur += areaPiscinaMsqr*1000;

        //__________________________
        if (this.acabamento == AcabamentoImovel.PARARESTAURO){
            valorImovelEur *= 0.5;
        } else if (this.acabamento == AcabamentoImovel.USADA) {
            valorImovelEur *= 0.9;
        } else if (this.acabamento == AcabamentoImovel.NOVAALTOACABAMENTO) {
            valorImovelEur *= 1.25;
        }

        return valorImovelEur;
    }

    public void setAcabamento(AcabamentoImovel acabamento) {
        this.acabamento = acabamento;
    }

    public void imprimirDescricao(){
        System.out.println("*********** "+this.tipo+" "+this.acabamento+" ************");
        System.out.println(this.rua+", "+this.portaNumero+" - "+this.cidade+":");
        System.out.println(this.areaImovelMsqr+" Metros quadrados,");
        System.out.println(this.numeroQuartos+" Quartos,");
        System.out.println(this.numeroCasasBanho+" Casas de banho");
        if (areaPiscinaMsqr > 0){
            System.out.println("Piscina: "+this.areaPiscinaMsqr+"Metros quadrados");
        }
    }

    public Imovel compararImoveis( Imovel aComparar ){
        if (this.calcularValor() > aComparar.calcularValor()) {
            return this;
        }
        else if ( aComparar.calcularValor() > this.calcularValor() ){
            return aComparar;
        }
        else return null;
    }
}
