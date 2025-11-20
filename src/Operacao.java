public abstract class Operacao {

    protected double valor;

    public Operacao(double valor) {
        this.valor = valor;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}