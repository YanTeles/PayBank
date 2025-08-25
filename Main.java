import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Bem vindo ao PayBank");
        System.out.println("Já possui conta?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        if(opcao == 1){
            System.out.println("Qual operacao deseja realizar?");
            System.out.println("1. Trasferencia");
            System.out.println("2. Sacar");
            System.out.println("3. Conferir Saldo");
            System.out.println("4. Depositar");
            System.out.println("5. Sair");
            int opcao3 = sc.nextInt();
            switch (opcao3){
                case 1: {
                    System.out.println("Digite o nome da conta");
                    String nome = sc.next();
                    Conta conta = Conta.getConta(nome);
                    if (conta == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }
                    System.out.println("Digite o valor da transação");
                    double valor = sc.nextDouble();
                    if (valor == 0 || valor > conta.getSaldo()) {
                        System.out.println("ERRO! ERRO! ERRO! ERRO! ERRO! ERRO!");
                        System.out.println("Valor inválido!");
                    } else {
                        System.out.println("Valor inserido: " + valor);
                        System.out.println("Saldo da conta: " + conta.getSaldo());
                        conta.depositar(valor);
                        System.out.println("Saldo da conta: " + conta.getSaldo());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome da conta");
                    String nome = sc.next();
                    Conta conta = Conta.getConta(nome);
                    if (conta == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }
                    if (conta.getSaldo() == 0) {
                        System.out.println("ERRO! ERRO! ERRO! ERRO! ERRO! ERRO!");
                        System.out.println("Saldo da conta: R$ 0");
                    } else {
                        System.out.println("Digite o valor que deseja sacar");
                        double valor = sc.nextDouble();
                        if (valor == 0 || valor > conta.getSaldo()) {
                            System.out.println("ERRO! ERRO! ERRO! ERRO! ERRO! ERRO!");
                            System.out.println("Valor inválido!");
                        } else {
                            System.out.println("Valor retirado: " + valor);
                            System.out.println("Saldo da conta: " + (conta.getSaldo() - valor));
                            conta.sacar(valor);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome da conta");
                    String nome = sc.next();
                    Conta conta = Conta.getConta(nome);
                    if (conta == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }
                    System.out.println("Saldo da conta: " + conta.getSaldo());
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome da conta");
                    String nome = sc.next();
                    Conta conta = Conta.getConta(nome);
                    if (conta == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }
                    System.out.println("Digite o valor que deseja depositar");
                    double valor = sc.nextDouble();
                    System.out.println("Saldo anterior: " + conta.getSaldo());
                    conta.depositar(valor);
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                }
                case 5: {
                    System.out.println("Deseja sair do programa?");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");
                    int opcao2 = sc.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Saindo do programa...");
                        System.exit(0);
                    }
                    break;
                }
                default:
                    break;
            }
            }
        else{ if (opcao ==2){
            System.out.println("Deseja criar uma conta?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            int opcao2 = sc.nextInt();
            if(opcao2 == 1){
                System.out.println("Digite o nome da conta");
                String nome = sc.next();
                System.out.println("Digite o tipo da conta");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta poupança");
                int tipoOpcao = sc.nextInt();
                String tipo = (tipoOpcao == 1) ? "Conta Corrente" : "Conta Poupança";
                Conta novaConta = Conta.criarConta(nome, tipo);
                if (novaConta == null) {
                    System.out.println("Já existe uma conta com esse nome!");
                } else {
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Nome: " + novaConta.getNome());
                    System.out.println("Tipo: " + novaConta.getTipo());
                    System.out.println("Saldo: R$ " + novaConta.getSaldo());
                }
            }
        }
        

    }
    }
}
