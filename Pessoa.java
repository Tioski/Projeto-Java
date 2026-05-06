package avaliacao;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pessoa {
    private int numero;
    private String agencia;
    private double saldo;
    private String titular;
    private ArrayList<Extrato> extrato = new ArrayList<>();

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
            pessoaSaida.extrato.add(new Extrato(LocalDate.now(), LocalTime.now(),
                    "Transferencia", "Saida", valor,
                    pessoaDestino.titular, pessoaSaida.titular,
                    pessoaDestino.numero, pessoaSaida.numero));

            pessoaDestino.extrato.add(new Extrato(LocalDate.now(), LocalTime.now(),
                    "Transferencia", "Entrada", valor,
                    pessoaDestino.titular, pessoaSaida.titular,
                    pessoaDestino.numero, pessoaSaida.numero));

        } else {
            System.out.println("Saldo insuficiente para transferência!");
            return;
        }
    }

    public void saldo(double valor, Pessoa pessoa) {
        System.out.println("Seu saldo é: ");
        System.out.println(pessoa.saldo);

    }

    public void depositar(double valor, Pessoa pessoa) {
        pessoa.saldo += valor;
        System.out.println("Valor depositado: ");
        System.out.println(valor);
        pessoa.extrato.add(new Extrato(LocalDate.now(), LocalTime.now(), "Deposito", "Entrada", valor, pessoa.titular,
                null, pessoa.numero, 0));
    }

    public void sacar(double valor, Pessoa pessoa) {
        if (pessoa.saldo >= valor) {
            pessoa.saldo -= valor;
            System.out.println("Valor sacado: ");
            System.out.println(valor);
            pessoa.extrato.add(new Extrato(LocalDate.now(), LocalTime.now(), "Saque", "Saida", valor, pessoa.titular,
                    null, pessoa.numero, 0));
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void gerarExtratoSimples() {
        System.out.println("=== EXTRATO ===");
        for (Extrato e : extrato) {
            System.out.println(e); // chama o toString() do Extrato
        }
        System.out.println("Saldo atual: R$" + saldo);
    }

}
