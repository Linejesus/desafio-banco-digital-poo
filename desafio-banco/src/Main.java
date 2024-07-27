
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();
        Conta corrente = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

        System.out.println("Conta corrente ou poupança? ");
        String tipoconta = scanner.next();

        System.out.println("Digite o seu nome: ");
        String nomeUsuario = scanner.next();
		cliente.setNome(nomeUsuario);

        int opcao = -1;

        while (opcao != 0) {            
            System.out.println("Menu Principal: ");
            System.out.println("1. Débito");
            System.out.println("2. Depósito");
            System.out.println("3. Extrato");
            System.out.println("4. Transferência entre contas");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if(opcao == 0){
                System.out.println("Saindo da Conta...");
            }
            else if(opcao == 1)
            {
                System.out.println("Digite o valor a ser debitado: ");
                double saque = scanner.nextDouble();
                if (tipoconta == "corrente")
                {
                    corrente.sacar(saque);
                }
                else {
                    poupanca.sacar(saque);
                }
            }
            else if(opcao == 2)
            {
                System.out.println("Digite o valor a ser depositado: ");
                double deposito = scanner.nextDouble();
                
                if (tipoconta == "corrente")
                {
                    corrente.depositar(deposito);
                }
                else {
                    poupanca.depositar(deposito);
                }
            }
            else if(opcao == 3)
            {
                if (tipoconta == "corrente")
                {
                    corrente.imprimirExtrato();
                }
                else {
                    poupanca.imprimirExtrato();
                }
            }
            else if(opcao == 4)
            {
                System.out.println("Digite o valor a ser transferido: ");
                double valortransferido = scanner.nextDouble();
                if (tipoconta == "corrente")
                {
                    corrente.transferir(valortransferido, poupanca);
                }
                else {
                    poupanca.transferir(valortransferido, corrente);
                }
            }
            else {
                System.out.println("Digite uma opção válida!");
            }

        }

        scanner.close();
	}

}