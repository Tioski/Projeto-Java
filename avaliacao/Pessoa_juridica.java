package avaliacao;

public class Pessoa_juridica extends Pessoa {
    private String cnpj;
    
    public Pessoa_juridica(int numero, String agencia, double saldo, String titular, String cnpj) {
        super(numero, agencia, saldo, titular);
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
}