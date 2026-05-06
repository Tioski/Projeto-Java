package avaliacao;

import java.util.ArrayList;
import java.util.Date;
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
            System.out.print("Escolha uma opcao: ");
            int opcao = receber.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione a opcao desejada:");
                    System.out.println("1. Pessoa Fisica");
                    System.out.println("2. Pessoa Juridica");
                    int escolha = receber.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println("Cadastro de Pessoa Fisica:");
                            cadastroPessoaFisica(pessoasFisicas);
                            break;
                        case 2:
                            System.out.println("Cadastro de Pessoa Juridica:");
                            cadastroPessoaJuridica(pessoasJuridicas);
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Entrar na conta:");
                    entrarConta(pessoasJuridicas, pessoasFisicas);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    public static void cadastroPessoaFisica(ArrayList<Pessoa_fisica> pessoasFisicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o numero da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agencia: ");
        String agencia = receber.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = receber.nextDouble();
        System.out.print("Digite o nome do titular: ");
        String titular = receber.next();
        System.out.print("Digite o CPF: ");
        String cpf = receber.next();

        System.out.print("Digite o dia de nascimento: ");
        int dia = receber.nextInt();
        System.out.print("Digite o mes de nascimento: ");
        int mes = receber.nextInt();
        System.out.print("Digite o ano de nascimento: ");
        int ano = receber.nextInt();
        Date dataNascimento = new Date(ano - 1900, mes - 1, dia);

        Pessoa_fisica pessoaFisica = new Pessoa_fisica(numero, agencia, saldo, titular, cpf, dataNascimento);
        pessoasFisicas.add(pessoaFisica);
        System.out.println("Pessoa Fisica cadastrada com sucesso!");
    }

    public static void cadastroPessoaJuridica(ArrayList<Pessoa_juridica> pessoasJuridicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o numero da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agencia: ");
        String agencia = receber.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = receber.nextDouble();
        System.out.print("Digite o nome do titular: ");
        String titular = receber.next();
        System.out.print("Digite o CNPJ: ");
        String cnpj = receber.next();

        Pessoa_juridica pessoaJuridica = new Pessoa_juridica(numero, agencia, saldo, titular, cnpj);
        pessoasJuridicas.add(pessoaJuridica);
        System.out.println("Pessoa Juridica cadastrada com sucesso!");
    }

    public static void entrarConta(ArrayList<Pessoa_juridica> pessoasJuridicas,
            ArrayList<Pessoa_fisica> pessoasFisicas) {
        System.out.println("Digite o tipo da conta: ");
        System.out.println("1. Pessoa Fisica");
        System.out.println("2. Pessoa Juridica");
        Scanner receber = new Scanner(System.in);
        int tipoConta = receber.nextInt();
        switch (tipoConta) {
            case 1:
                entrarPessoaFisica(pessoasFisicas, pessoasJuridicas);
                break;
            case 2:
                entrarPessoaJuridica(pessoasJuridicas, pessoasFisicas);
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }

    public static void entrarPessoaJuridica(ArrayList<Pessoa_juridica> pessoas,
            ArrayList<Pessoa_fisica> pessoasFisicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o numero da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agencia: ");
        String agencia = receber.next();

        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            System.out.println("Bem-vindo, " + pessoaEncontrada.getTitular() + "!");
            operacoesBancarias(pessoaEncontrada, pessoas, pessoasFisicas);
        } else {
            System.out.println("Numero da conta ou agencia invalidos. Tente novamente.");
        }
    }

    public static void entrarPessoaFisica(ArrayList<Pessoa_fisica> pessoas,
            ArrayList<Pessoa_juridica> pessoasJuridicas) {
        Scanner receber = new Scanner(System.in);
        System.out.print("Digite o numero da conta: ");
        int numero = receber.nextInt();
        System.out.print("Digite a agencia: ");
        String agencia = receber.next();

        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            System.out.println("Bem-vindo, " + pessoaEncontrada.getTitular() + "!");
            operacoesBancarias(pessoaEncontrada, pessoasJuridicas, pessoas);
        } else {
            System.out.println("Numero da conta ou agencia invalidos. Tente novamente.");
        }
    }

    public static void operacoesBancarias(Pessoa pessoa, ArrayList<? extends Pessoa> lista1,
            ArrayList<? extends Pessoa> lista2) {
        Scanner receber = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione a operacao desejada:");
            System.out.println("1. Transferencia");
            System.out.println("2. Extrato");
            System.out.println("3. Saldo");
            System.out.println("4. Deposito");
            System.out.println("5. Saque");
            System.out.println("6. Sair");
            int opcao = receber.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o numero da conta de destino: ");
                    int numeroDestino = receber.nextInt();
                    System.out.println("Digite a agencia de destino: ");
                    String agenciaDestino = receber.next();
                    System.out.println("Digite o valor da transferencia: ");
                    double valorTransferencia = receber.nextDouble();

                    Pessoa pessoaDestino = buscarPessoa(lista1, numeroDestino, agenciaDestino);
                    if (pessoaDestino == null) {
                        pessoaDestino = buscarPessoa(lista2, numeroDestino, agenciaDestino);
                    }
                    if (pessoaDestino != null) {
                        pessoa.transferencia(pessoaDestino, valorTransferencia);
                    } else {
                        System.out.println("Conta de destino nao encontrada!");
                    }
                    break;
                case 2:
                    pessoa.extrato();
                    break;
                case 3:
                    pessoa.saldo();
                    break;
                case 4:
                    System.out.print("Digite o valor do deposito: ");
                    double valorDeposito = receber.nextDouble();
                    pessoa.depositar(valorDeposito);
                    break;
                case 5:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = receber.nextDouble();
                    pessoa.sacar(valorSaque);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    public static Pessoa buscarPessoa(ArrayList<? extends Pessoa> pessoas, int numero, String agencia) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNumero() == numero && pessoa.getAgencia().equals(agencia)) {
                System.out.println("Pessoa encontrada: " + pessoa.getTitular());
                return pessoa;
            }
        }
        return null;
    }
}
