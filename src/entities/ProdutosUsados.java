package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutosUsados extends Produtos {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataFabricacao;
	
	public ProdutosUsados() {
		super();
	}

	public ProdutosUsados(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String tagPreco() {
		return getNome() 
				+ " (usado) " 
				+ String.format("%.2f", getPreco()) 
				+ " (Data de fabricacao: " 
				+ sdf.format(dataFabricacao) 
				+ ")";
	}
}
