import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Functions banco = new Functions(scanner);

        int opcao;
        String cpf;

        do {

            System.out.println("\n==============================");
            System.out.println("      BANCO JAVA");
            System.out.println("==============================");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Consultar Saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o ENTER

            switch (opcao) {

                case 1:
                    banco.CriarConta("", 0);
                    break;

                case 2:
                    System.out.print("Informe o CPF: ");
                    cpf = scanner.nextLine();
                    banco.ConsultarSaldo(cpf);
                    break;

                case 3:
                    System.out.print("Informe o CPF: ");
                    cpf = scanner.nextLine();
                    banco.Depositar(cpf);
                    break;

                case 4:
                    System.out.print("Informe o CPF: ");
                    cpf = scanner.nextLine();
                    banco.Sacar(cpf);
                    break;

                case 5:
                    System.out.println("Obrigado por utilizar o sistema!");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        } while (opcao != 5);

        scanner.close();
    }
}