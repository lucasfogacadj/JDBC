import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int opc;
		
		@SuppressWarnings("resource")
		Scanner tc = new Scanner(System.in);

		
		do{
			System.out.println("1- Cadastrar Pessoa\n2- Excluir por nome:\n3- Excluir por id\n4- Consultar toda a tabela\n5- Sair");
			opc=tc.nextInt();
			switch(opc){
			
			case 1:{
				Pessoa p = new Pessoa();
				p.addBanco();
				break;
			}
			
			case 2:{
				Pessoa.removerNome();
				break;
			}
			case 3:{
				Pessoa.removerId();
				break;
			}
			
			case 4:{
				Pessoa.Consulta();
			}
			
			}
			
			
			
		}while(opc!=5);
		

	}
}
