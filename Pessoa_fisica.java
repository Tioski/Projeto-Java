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
    @Override
    public void transferencia(Pessoa pessoaSaida, Pessoa pessoaDestino, double valor) {
        if (valor> 20000) {
            System.out.println("Tranfereica negada! O VALOR EXEDE O LIMITE DE TRANSFERENCIA PARA PESSOA FISICA! ");
            return;
            
        }
        super.transferencia(pessoaSaida, pessoaDestino, valor);
    }
}


