package avaliacao;

import java.sql.Time;
import java.util.Date;

public class Extrato extends Pessoa {
    private Date data;
    private Time hora;
    private String tipo;
    private double valor;

    public Extrato(int numero, String agencia, double saldo, String titular, Date data, Time hora, String tipo,
            double valor) {
        super(numero, agencia, saldo, titular);
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public Time getHora() {
        return hora;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}