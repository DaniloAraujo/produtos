package entities;

public class ProdutosImportados extends Produtos {
	
	private Double alfandega;
	
	public ProdutosImportados() {
		super();
	}

	public ProdutosImportados(String nome, Double preco, Double alfandega) {
		super(nome, preco);
		this.alfandega = alfandega;
	}

	public Double getAlfandega() {
		return alfandega;
	}

	public void setAlfandega(Double alfandega) {
		this.alfandega = alfandega;
	}
	
	public Double totalPreco() {
		return getPreco() + alfandega;
	}
	
	@Override
	public String tagPreco() {
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", totalPreco()) 
				+ " (Custos Alfandega: $ " 
				+ String.format("%.2f", alfandega) 
				+ ")";
	}
	

}
