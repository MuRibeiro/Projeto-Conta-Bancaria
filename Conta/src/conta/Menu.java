package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
			
			Scanner leia = new Scanner(System.in);
			
			ContaController contas = new ContaController();
			
			String titular;
			float saldo, limite, valor;
			int opcao, numero, agencia, tipo, aniversario, numeroDestino;
			
			while (true) {
				
				System.out.println("                                                     *****       ");
				System.out.println("                                                    *     *      ");
				System.out.println("													 *   		 ");
				System.out.println("                                                     *****       ");
				System.out.println("                                                    *     *      ");
				System.out.println("                                                     *****       ");
				System.out.println("                                         ");
				System.out.println("");
				System.out.println("*****************************************************************");
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
				System.out.println("                                                                 ");
				
				try {
					opcao = leia.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Opção Inválida. Por favor, digite valor inteiro!");
					leia.nextLine();
					opcao = 0;
				}
				
				if (opcao == 9) {
					System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
					leia.close();
					System.exit(0);
				}
				
				switch (opcao) {
					case 1: 
						System.out.println("Criar Conta\n\n");
						
						System.out.println("Número da Agencia: ");
						agencia = leia.nextInt();
						
						System.out.println("Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
						
						do {
							System.out.println("Tipo da Conta (1 - CC / 2 - CP): ");
							tipo = leia.nextInt();
						}while(tipo < 1 && tipo > 2);
						
						System.out.println("Saldo da Conta: ");
						saldo = leia.nextFloat();
						
						switch(tipo) {
							case 1 ->{
								System.out.println("Limite da Conta Corrente: ");
								limite = leia.nextFloat();
								contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
								//cc.visualizar();
							}
							
							case 2 -> {
								System.out.println("Aniversário da Conta Poupança");
								aniversario = leia.nextInt();
								contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
								//cp.visualizar();
							}	
						}
						
						keyPress();
						break;
					
					case 2:
						System.out.println("Listar todas as Contas\n\n");

						contas.listarTodas();
						
						keyPress();
						break;
					
					case 3:
						System.out.println("Consultar dados da conta - por número\n\n");
						
						System.out.println("Número da Conta: ");
						numero = leia.nextInt();
						
						contas.procurarPorNumero(numero);
						
						keyPress();
						break;
					
					case 4: 
						System.out.println("Atualizar dados da conta\n\n");
						
						System.out.println("Número da Conta: ");
						numero = leia.nextInt();
						
						if(contas.buscarNaCollection(numero) != null) {
			
						
							System.out.println("Número da Agencia: ");
							agencia = leia.nextInt();
							
							System.out.println("Nome do Titular: ");
							leia.skip("\\R?");
							titular = leia.nextLine();
							
							tipo = contas.retornaTipo(numero);
							
							System.out.println("Saldo da Conta: ");
							saldo = leia.nextFloat();
							
							switch(tipo) {
								case 1 ->{
									System.out.println("Limite da Conta Corrente: ");
									limite = leia.nextFloat();
									contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
								}
								
								case 2 -> {
									System.out.println("Aniversário da Conta Poupança");
									aniversario = leia.nextInt();
									contas.atualizar(new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario));
									
								}
							}
						}else 
								System.out.println("A conta não foi encontrada");
						
						keyPress();
						break;
					
					case 5: 
						System.out.println("Apagar a conta\n\n");
						
						System.out.println("Número da Conta: ");
						numero = leia.nextInt();
						
						contas.deletar(numero);
						
						keyPress();
						break;
					
					case 6:
						System.out.println("Saque\n\n");
						
						System.out.println("Número da Conta: ");
						numero = leia.nextInt();
						
						System.out.println("Valor do Saque: ");
						valor = leia.nextFloat();
						
						contas.sacar(numero, valor);
						
						keyPress();
						break;
					
					case 7: 
						System.out.println("Depósito\n\n");
						
						System.out.println("Número da Conta: ");
						numero = leia.nextInt();
						
						System.out.println("Valor do Depósito: ");
						valor = leia.nextFloat();
						
						contas.depositar(numero, valor);
						
						keyPress();
						break;
					
					case 8:
						System.out.println("Transferência entre contas\n\n");

						System.out.println("Número da Conta - Origem: ");
						numero = leia.nextInt();
						
						System.out.println("Número da Conta - Destino: ");
						numeroDestino = leia.nextInt();
						
						System.out.println("Valor do Transferência: ");
						valor = leia.nextFloat();
						
						contas.transferir(numero, numeroDestino, valor);
						
						keyPress();
						break;
					
					default:
						System.out.println("\nOpção Inválida!");
						System.out.println("Digite uma opção de (1 - 9)\n");

						keyPress();
						break;
				}
			}
	}
	
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}


}
