package avaliacao;

import java.util.ArrayList;

public class Pessoa {
    private int numero;
    private String agencia;
    private double saldo;
    private String titular;
    private ArrayList<Extrato> operacoes = new ArrayList<>();

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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferencia(Pessoa pessoaDestino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            pessoaDestino.saldo += valor;
            operacoes.add(new Extrato("Transferencia enviada", valor, numero, pessoaDestino.numero));
            pessoaDestino.operacoes.add(new Extrato("Transferencia recebida", valor, numero, pessoaDestino.numero));
            System.out.println("Transferencia realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para transferencia!");
        }
    }

    public void extrato() {
        System.out.println("Extrato da conta: " + numero + " Agencia: " + agencia + " Titular: " + titular);
        if (operacoes.isEmpty()) {
            System.out.println("Nenhuma operacao registrada.");
        } else {
            for (Extrato op : operacoes) {
                System.out.println("Data/Hora: " + op.getDataHora() 
                    + " | Tipo: " + op.getTipo() 
                    + " | Valor: " + op.getValor() 
                    + " | Conta origem: " + op.getContaOrigem() 
                    + " | Conta destino: " + op.getContaDestino());
            }
        }
        System.out.println("Saldo atual: " + saldo);
    }

    public void saldo() {
        System.out.println("Seu saldo e: " + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
        operacoes.add(new Extrato("Deposito", valor, numero, numero));
        System.out.println("Valor depositado: " + valor);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            operacoes.add(new Extrato("Saque", valor, numero, numero));
            System.out.println("Valor sacado: " + valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
