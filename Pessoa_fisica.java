package avaliacao;

import java.util.Date;

public class Pessoa_fisica extends Pessoa {

    private String cpf;
    private Date dataNascimento;

    public Pessoa_fisica(int numero, String agencia, double saldo, String titular, String cpf, Date dataNascimento) {
        super(numero, agencia, saldo, titular);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void transferencia(Pessoa pessoaDestino, double valor) {
        if (valor > 2000.00) {
            System.out.println("Limite de transferencia para Pessoa Fisica e R$ 2000,00!");
        } else {
            super.transferencia(pessoaDestino, valor);
        }
    }
}
