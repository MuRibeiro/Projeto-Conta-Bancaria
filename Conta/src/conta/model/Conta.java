package conta.model;

public abstract class Conta {

	// cria as caracteristicas da classe conta. 
			private int numero;
			private int agencia;
			private int tipo;
			private String titular;
			private float saldo;
			
			//cria o metodo construtor.
			public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
				//insere os parametros. sao iguais porque vai receber os dados que o usuario esta digitando
				//this usada para identificar quem é atributo e quem é parametro
				this.numero = numero;
				this.agencia = agencia;
				this.tipo = tipo;
				this.titular = titular;
				this.saldo = saldo;
			}
			// get - recupera a informação
			public int getNumero() {
				return numero;
			}
			//altera a informação
			public void setNumero(int numero) {
				this.numero = numero;
			}

			public int getAgencia() {
				return agencia;
			}

			public void setAgencia(int agencia) {
				this.agencia = agencia;
			}

			public int getTipo() {
				return tipo;
			}

			public void setTipo(int tipo) {
				this.tipo = tipo;
			}

			public String getTitular() {
				return titular;
			}

			public void setTitular(String titular) {
				this.titular = titular;
			}

			public float getSaldo() {
				return saldo;
			}

			public void setSaldo(float saldo) {
				this.saldo = saldo;
			}
			
			public boolean sacar(float valor) {
				
				if (this.getSaldo() < valor) {
					System.out.println("\nSaldo insuficiente!");
					return false;
				}
				
				this.setSaldo(this.getSaldo() - valor);
				return true;
			}	
			
			public void depositar(float valor) {
				
				this.setSaldo(this.getSaldo() + valor);
			}
			
			public void visualizar() {// metodo para visualizar todas informações
				
				String tipo = " ";
				
				switch(this.tipo) {
					case 1 -> tipo = "Conta Corrente";
					case 2 -> tipo = "Conta Poupança";
				}
				System.out.println("************************");
				System.out.println("*   DAODS DA CONTA     *");
				System.out.println("************************");
				System.out.println("Número da Conta: " + this.numero);
				System.out.println("Número da Agência: " + this.agencia);
				System.out.println("Tipo da Conta: " + tipo);
				System.out.println("Nome do Titular: " + this.titular);
				System.out.println("Saldo da Conta: " + this.saldo);
				
			}
		

	
}
