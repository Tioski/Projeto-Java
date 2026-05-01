package avaliacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner receber = new Scanner(System.in);
        ArrayList<Pessoa_fisica> pessoasFisicas = new ArrayList<>();
        ArrayList<Pessoa_juridica> pessoasJuridicas = new ArrayList<>();
        while (continuar) {
            System.out.println("Menu");
            System.out.println("1. Cadastrar");
            System.out.println("2. Entrar na conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = receber.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Selecione a opção desejada:");
                    System.out.println("1. Pessoa Física");
                    System.out.println("2. Pessoa Jurídica");
                    int escolha = receber.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println("Cadastro de Pessoa Física:");
                            cadastroPessoaFisica(pessoasFisicas);
                            break;
                        case 2:
                            System.out.println("Cadastro de Pessoa Jurídica:");
                            cadastroPessoaJuridica(pessoasJuridicas);
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Entrar na conta:");
                    // Lógica para entrar na conta

                    entrarConta(pessoasJuridicas, pessoasFisicas);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastroPessoaFisica(ArrayList<Pessoa_fisica> pessoasFisicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agência: ");
        String agencia = receber.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = receber.nextDouble();
        System.out.print("Digite o nome do titular: ");
        String titular = receber.next();
        System.out.print("Digite o CPF: ");
        String cpf = receber.next();

        Pessoa_fisica pessoaFisica = new Pessoa_fisica(numero, agencia, saldo, titular, cpf);
        pessoasFisicas.add(pessoaFisica);

        // Lógica para armazenar a pessoa física cadastrada
    }

    public static void cadastroPessoaJuridica(ArrayList<Pessoa_juridica> pessoasJuridicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agência: ");
        String agencia = receber.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = receber.nextDouble();
        System.out.print("Digite o nome do titular: ");
        String titular = receber.next();
        System.out.print("Digite o CNPJ: ");
        String cnpj = receber.next();

        Pessoa_juridica pessoaJuridica = new Pessoa_juridica(numero, agencia, saldo, titular, cnpj);
        // Lógica para armazenar a pessoa jurídica cadastrada
    }

    public static void entrarConta(ArrayList<Pessoa_juridica> pessoasJuridicas,
            ArrayList<Pessoa_fisica> pessoasFisicas) {
        System.out.println("Digite o tipo da conta: ");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        Scanner receber = new Scanner(System.in);
        int tipoConta = receber.nextInt();
        switch (tipoConta) {
            case 1:
                // Lógica para entrar na conta de pessoa física
                entrarPessoaFisica(pessoasFisicas);
                break;
            case 2:
                entrarPessoaJuridica(pessoasJuridicas);
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    public static void entrarPessoaJuridica(ArrayList<Pessoa_juridica> pessoas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agência: ");
        String agencia = receber.next();
        // Lógica para verificar as credenciais e permitir o acesso à conta
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                // Acesso concedido, exibir opções de operações bancárias
                System.out.println("Bem-vindo, " + pessoa.getTitular() + "!");
                // Lógica para exibir opções de operações bancárias (transferência, extrato,
                // saldo, depósito, saque)
                operacoesBancarias(pessoa, pessoas);
            } else {
                System.out.println("Número da conta ou agência inválidos. Tente novamente.");
            }
        }
    }

    public static void entrarPessoaFisica(ArrayList<Pessoa_fisica> pessoas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agência: ");
        String agencia = receber.next();
        // Lógica para verificar as credenciais e permitir o acesso à conta
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                // Acesso concedido, exibir opções de operações bancárias
                System.out.println("Bem-vindo, " + pessoa.getTitular() + "!");
                // Lógica para exibir opções de operações bancárias (transferência, extrato,
                // saldo, depósito, saque)
                operacoesBancarias(pessoa, pessoas);
            } else {
                System.out.println("Número da conta ou agência inválidos. Tente novamente.");
            }
        }
    }
    public static void operacoesBancarias(Pessoa pessoa, ArrayList<? extends Pessoa> pessoas) {
        Scanner receber = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione a operação desejada:");
            System.out.println("1. Transferência");
            System.out.println("2. Extrato");
            System.out.println("3. Saldo");
            System.out.println("4. Depósito");
            System.out.println("5. Saque");
            System.out.println("6. Sair");
            int opcao = receber.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta de destino: ");
                    int numeroDestino = receber.nextInt();
                    System.out.println("Digite a agência de destino: ");    
                    String agenciaDestino = receber.next();
                    System.out.println("Digite o valor da transferência: ");
                    double valorTransferencia = receber.nextDouble();
                    Pessoa pessoaSaida = buscarPessoa(pessoas, numeroDestino, agenciaDestino);
                    pessoa.transferencia(pessoa, pessoaSaida, valorTransferencia);
                    break;
                case 2:
                    pessoa.extrato();
                    break;
                case 3:
                    pessoa.saldo(0, pessoa);
                    break;
                case 4:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = receber.nextDouble();
                    pessoa.depositar(valorDeposito, pessoa);
                    break;
                case 5:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = receber.nextDouble();
                    pessoa.sacar(valorSaque, pessoa);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    public static Pessoa buscarPessoa(ArrayList<? extends Pessoa> pessoas, int numero, String agencia) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                // Pessoa encontrada, realizar as operações desejadas
                System.out.println("Pessoa encontrada: " + pessoa.getTitular());
                // Lógica para realizar as operações desejadas
                return pessoa;
            }
        }
        return null;
    }
}