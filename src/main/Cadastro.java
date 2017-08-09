package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Cadastro {
	
	//int ID;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String arquivo = "pessoa.ser";
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		//Adicionando pessoas para a lista pessoas
		pessoas.add(new Pessoa("Gabriel"));
		pessoas.add(new Pessoa("Andressa"));
		pessoas.add(new Pessoa("Jeremias"));
		try{
			//Essa linha irá criar um novo arquivo e atribuí-lo à variável f
			FileOutputStream f = new FileOutputStream(arquivo);
			//Prepara o arquivo para receber entradas
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			//Escreve a lista agenda no arquivo
			o.writeObject(pessoas);
			
			//Desaloca recursos do arquivo criado e retorna para a memória
			o.close();
			o = null;
			f.close();
			f = null;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//Recuperando os objetos do arquivo
		try{
			//Abre o arquivo e atribui à variável f
			FileInputStream f = new FileInputStream(arquivo);
			//Prepara o arquivo para ser lido
			ObjectInputStream o = new ObjectInputStream(f);
			
			//A variável obj do tipo mais genérico (Object) recebe o objeto do arquivo
			//Como não sei o tipo do objeto que vou receber, deve ser o tipo mais genérico
			Object obj = o.readObject();
			
			//A lista agenda recebe o objeto que foi lido do arquivo
			//É necessário fazer casting para o tipo a atribuir
			pessoas = (ArrayList<Pessoa>)obj;
			
			//Desaloca recursos do arquivo criado e retorna para a memória
			o.close();
			o = null;
			f.close();
			f = null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Print dos nome de cada pessoa na lista agenda
		for(Pessoa a: pessoas){
			System.out.println(a.getNome());
		}
	}
}