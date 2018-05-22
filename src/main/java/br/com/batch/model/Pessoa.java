package br.com.batch.model;

public class Pessoa {

	private String nome;
	private Integer idade;
	private String mae;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Integer idade, String mae) {
		this();
		this.nome = nome;
		this.idade = idade;
		this.mae = mae;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", mae=" + mae + "]";
	}
	
}
