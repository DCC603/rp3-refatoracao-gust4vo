import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;

    private int numAgencia;
    private int numConta;
    private String gerente;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, int numAgencia, int numConta, String gerente, double saldoInicial) {
        this.cliente = cliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public void depositar(double valor) {
        Operacao op = new Deposito(valor);
        this.operacoes.add(op);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        Operacao op = new Saque(valor);
        this.operacoes.add(op);
        this.saldo -= valor;
    }

    private String gerarExtrato() {
        StringBuilder dadosExtrato = new StringBuilder();
        for(Operacao op : this.operacoes) {
            dadosExtrato.append(op.toString()).append("\n");
        }
        return dadosExtrato.toString();
    }

    @Override
    public String toString() {
        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.saldo);

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                this.gerarExtrato() +
                "\n";
    }
}