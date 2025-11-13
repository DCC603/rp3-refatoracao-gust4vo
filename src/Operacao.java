public class Operacao {

    private char tipo;
    private double valor;

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // TODO(#6) REFATORAR: Muita responsabilidade para mesma classe
    public String getTipo() {
        switch (this.tipo) {
            case 'd':
                return "Depósito";
            case 's':
                return "Saque";
            default:
                return null;
        }
    }

    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
