package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
			
			Scanner leia = new Scanner(System.in);
			
			//Criamos o Objeto Conta
			Conta c1 = new Conta(1, 123, 1, "Murilo Ribeiro", 30000.f);// instaciamos o objeto CONTA e entramos com os dados
			
			//Visualizamos os dados da conta c1
			c1.visualizar(); // chama o metodo para mostrar todas as informações na tela
			
			//Alteramos o Saldo da Conta c1
			c1.setSaldo(35000.0f); // chama o set para alterar a informação do saldo
			
			//Visualizamos apenas o Saldo da Conta c1
			System.out.println("\n" + c1.getSaldo());// chama o get para mostrar o saldo alterado
			
			//Criamos a Conta c2
			Conta c2 = new Conta(2, 123, 2, "Juliana Ribeiro", 300000.f);// instaciamos o objeto CONTA e entramos com os dados
			
			//Visualizamos a Conta c2
			c2.visualizar();
			
			//Efetuamos um Saque na Conta c2 e visualizamos e novo Saldo 
			if(c2.sacar(1000000.0f));
				System.out.println("\nSaldo dísponivel: " + c2.getSaldo());
			
			//Efetuamos um Deposito na Conta c1
			c1.depositar(10000.0f);
			
			//Visualizamos os dados da Conta c1 após o Depósito
			c1.visualizar();
			
			ContaCorrente c3 = new ContaCorrente(3, 123, 1, "Murilo Ribeiro", 30000.f, 10000.0f);
			
			c3.visualizar();
			
			c3.sacar(35000);
			
			c3.visualizar();
			
			ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
			cp1.visualizar();
			cp1.sacar(1000.0f);
			cp1.visualizar();
			cp1.depositar(5000.0f);
			cp1.visualizar();
			
			int opcao;
			
			while (true) {
				
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************************");
				System.out.println("*                                                               *");
				System.out.println("*                   BANCO DO BRAZIL COM Z                       *");
				System.out.println("*                                                               *");
				System.out.println("*****************************************************************");
				System.out.println("                                                                 ");
				System.out.println("             1 - Criar Conta                                     ");
				System.out.println("             2 - Listar todas as contas                          ");
				System.out.println("             3 - Buscar Conta por Número                         ");
				System.out.println("             4 - Atualizar Dados da Conta                        ");
				System.out.println("             5 - Apagar Conta                                    ");
				System.out.println("             6 - Sacar                                           ");
				System.out.println("             7 - Depositar                                       ");
				System.out.println("             8 - Transferir valores entre contas                 ");
				System.out.println("             9 - Sair                                            ");
				System.out.println("                                                                 ");
				System.out.println("*****************************************************************");
				System.out.println("Informe a opção desejada:                                        ");
				System.out.println("                                                                 " + Cores.TEXT_RESET);
				
				opcao = leia.nextInt();
				
				if (opcao == 9) {
					System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
					leia.close();
					System.exit(0);
				}
				
				switch (opcao) {
					case 1: 
						System.out.println("Criar Conta\n\n");
						
						break;
					
					case 2:
						System.out.println("Listar todas as Contas\n\n");
					
						break;
					
					case 3:
						System.out.println("Consultar dados da conta - por número\n\n");
					
						break;
					
					case 4: 
						System.out.println("Atualizar dados da conta\n\n");
						
						break;
					
					case 5: 
						System.out.println("Apagar a conta\n\n");
						
						break;
					
					case 6:
						System.out.println("Saque\n\n");
						
						break;
					
					case 7: 
						System.out.println("Depósito\n\n");
						
						break;
					
					case 8:
						System.out.println("Transferência entre contas\n\n");
					
						break;
					
					default:
						System.out.println("\nOpção Inválida!\n");
					
						break;
				}
			}
	}

}
