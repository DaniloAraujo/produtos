package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produtos;
import entities.ProdutosImportados;
import entities.ProdutosUsados;

public class ProgramaProdutos {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produtos> list = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o numero de produtos: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Produto #" + i);
			System.out.print("Novo, usado ou importado (n/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Preco: ");
			double preco = sc.nextDouble();
			if(ch == 'n') {
				list.add(new Produtos(nome, preco));
			}
			else if(ch == 'u') {
				System.out.print("Data de fabricacao: (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutosUsados(nome, preco, data));
			}
			else {
				System.out.print("Produto importado: ");
				double importado = sc.nextDouble();
				list.add(new ProdutosImportados(nome, preco, importado));
			}
		}

		System.out.println();
		System.out.println("Preco dos produtos: ");
		for(Produtos pd : list) {
			System.out.println(pd.tagPreco());
		}
		
		sc.close();
	}
}
