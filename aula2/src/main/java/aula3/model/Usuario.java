package aula3.model;

//Desafio3: configurar o lombok
//@getter
//@setter
public class Usuario {
	
	private String nome;
	private String cpf;
	private int idade;
	private double altura;
	private String genero;
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String nome, String cpf, int idade, double altura, String genero) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.altura = altura;
		this.genero = genero;
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "============================"
				+"\nNOME:   " +  this.nome
				+"\nCPF:    " +  this.cpf 
				+"\nIDADE:  " + this.idade 
				+"\nALTURA: " + this.altura 
				+"\nGÊNERO: " + this.genero
				+"\n============================";
	}

	

}
