import java.util.Scanner;

public class Main {

    public static void Main(String[] args) {
        
        System.out.println("Bem vindo ao PayBank");
        System.out.println("Já possui conta?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        if(opcao == 1){
            System.out.println("Qual operacao deseja realizar?");
            
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
                Conta novaConta = new Conta(nome, tipo);
                System.out.println("Conta criada com sucesso!");
                System.out.println("Nome: " + novaConta.getNome());
                System.out.println("Tipo: " + novaConta.getTipo());
                System.out.println("Saldo: R$ " + novaConta.getSaldo());
            }
            
        }
        

    }
    }
}
