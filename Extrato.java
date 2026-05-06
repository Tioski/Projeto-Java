package avaliacao;

import java.util.Date;

public class Extrato {
    private Date dataHora;
    private String tipo;
    private double valor;
    private int contaOrigem;
    private int contaDestino;

    public Extrato(String tipo, double valor, int contaOrigem, int contaDestino) {
        this.dataHora = new Date();
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public Date getDataHora() {;
        
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public int getContaOrigem() {
        return contaOrigem;
    }

    public int getContaDestino() {
        return contaDestino;
    }
}
