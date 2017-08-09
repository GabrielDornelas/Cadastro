package main;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Pessoa implements Serializable{
	String nome;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}