package ex2.demo;
import java.util.*;

public class Principal {
	public static void main(String[] args) {
	//--> ATRIBUTOS
		DAO dao = new DAO();
		Scanner scan = new Scanner(System.in);
		int x = 0;
	//--> DAO
		dao.conectar();
	//--> MENU
		do {
		//--> ATRIBUTOS PAR CRIAR PRODUTO
			int id, qnt; 
			String device_name, device_category;
		//--> TEXTO MENU
			System.out.printf("\n\n");
			System.out.println("1 - Listar");
			System.out.println("2 - Inserir");
			System.out.println("3 - Excluir");
			System.out.println("4 - Atualizar");
			System.out.println();
			System.out.println("0 - Encerrar programa");
			System.out.printf("\n\n");
			System.out.print("Escolha uma opcao: ");
			x = scan.nextInt();
			scan.nextLine();
		//--> SWITCH MENU
			switch (x) {
			//--> SAIR
				case 0: //sair
					
					break;
			//--> LISTAR
				case 1: //listar
					Produto[] produtos = dao.getProdutos();
					System.out.println("==== Mostrar Produtos === ");
					for (int i = 0; i < produtos.length; i++) {
						System.out.println(produtos[i].toString());
					} 
					break;
			//--> INSERIR
				case 2: //inserir
					System.out.println("Inserir id: ");
					id = scan.nextInt();
					scan.next();
					System.out.println("Inserir nome do device: ");
					device_name = scan.nextLine();
					System.out.println("Inserir categoria do device: ");
					device_category = scan.nextLine();
					System.out.println("Inserir quantidade: ");
					qnt = scan.nextInt();
					scan.nextLine();
					Produto produto = new Produto(id, device_name, device_category, qnt);
					if (dao.inserirProduto(produto) == true) {
						System.out.println("Inserção com sucesso -> " + produto.toString());
					}
					break;
			//--> EXCLUIR
				case 3: //excluir
					System.out.print("Inserir id: ");
					id = scan.nextInt();
					scan.nextLine();
					dao.excluirProduto(id);
					break;
			//--> ATUALIZAR
				case 4: //atualizar
					System.out.print("inserir id: ");
					id = scan.nextInt();
					scan.nextLine();
					dao.atualizarProduto(id, scan);
					break;
			//--> DEFAULT
				default:
					System.out.println();
					Principal.clearConsole();
					System.out.println("Opcao invalida");
					break;
			}
		}while(x != 0);
		
	//--> FECHAR DAO
		dao.close();
	}//END_MAIN
//--> CLEAR CONSOLE
	private final static void clearConsole() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}
}
