package entities;

public class Produto {
	private String nome;
	private Integer qtd;
	private Double valor;
	
	public Produto() {
		
	}
	
	public Produto(String nome, Integer qtd, Double valor) {
		super();
		this.nome = nome;
		this.qtd = qtd;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Double total() {
		return valor * qtd;
	}
}
