package avaliacao;

public class Pessoa_fisica extends Pessoa{

    private String cpf;
    public Pessoa_fisica(int numero, String agencia, double saldo, String titular, String cpf) {
        super(numero, agencia, saldo, titular);
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
}


