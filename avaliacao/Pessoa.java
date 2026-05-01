package avaliacao;

public class Pessoa {
    private int numero;
    private String agencia;
    private double saldo;
    private String titular;

    public Pessoa(int numero, String agencia, double saldo, String titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void transferencia(Pessoa pessoaSaida, Pessoa pessoaDestino, double valor) {
        if (pessoaSaida.saldo > valor) {
            pessoaSaida.saldo -= valor;
            pessoaDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso!");

        } else {
            System.out.println("Saldo insuficiente para transferência!");
            return;
        }
    }

    public void extrato() {
        System.out.println("O ");
    }

    public void saldo(double valor, Pessoa pessoa) {
        System.out.println("Seu saldo é: ");
        System.out.println(pessoa.saldo);

    }

    public void depositar(double valor, Pessoa pessoa) {
        pessoa.saldo += valor;
        System.out.println("Valor depositado: ");
        System.out.println(valor);
    }

    public void sacar(double valor, Pessoa pessoa) {
        if (pessoa.saldo >= valor) {
            pessoa.saldo -= valor;
            System.out.println("Valor sacado: ");
            System.out.println(valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

}
