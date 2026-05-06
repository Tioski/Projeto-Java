package avaliacao;

import java.time.LocalDate;
import java.time.LocalTime;

public class Extrato {
    private LocalDate data;
    private LocalTime hora;
    private String descricao;
    private String tipo;
    private double valor;
    private String titularDestino;
    private String titularOrigem;
    private int numeroDestino;
    private int numeroOrigem;

    public Extrato(LocalDate data, LocalTime hora, String descricao, String tipo, double valor, String titularDestino,
            String titularOrigem, int numeroDestino, int numeroOrigem) {
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.titularDestino = titularDestino;
        this.numeroDestino = numeroDestino;
        this.titularOrigem = titularOrigem;
        this.numeroOrigem = numeroOrigem;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getTitularDestino() {
        return titularDestino;
    }

    public String getTitularOrigem() {
        return titularOrigem;
    }

    public int getNumeroDestino() {
        return numeroDestino;
    }

    public int getNumeroOrigem() {
        return numeroOrigem;
    }

    public String toString() {
    String resultado = "==============================\n" +
                       "- Data:      " + data + "\n" +
                       "- Hora:      " + hora + "\n" +
                       "- Descrição: " + descricao + "\n" +
                       "- Tipo:      " + tipo + "\n" +
                       "- Valor:     R$ " + String.format("%.2f", valor) + "\n" +
                       "- Titular:   " + titularDestino;

    if (titularOrigem != null) {
        resultado += "\nPara:      " + titularDestino +
                     "\n De:        " + titularOrigem;
    }

    resultado += "\n==============================";
    return resultado;
}


}