package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class TestCadastro {

	@SuppressWarnings("unchecked")
	@Test
	public void main() {
		String arquivo = "pessoa.ser";
		ArrayList<String> pessoas = new ArrayList<String>();
		//Adicionando pessoas para a lista pessoas
		pessoas.add(new String("Gabriel"));
		pessoas.add(new String("Andressa"));
		pessoas.add(new String("Jeremias"));
		try{
			//Essa linha ir� criar um novo arquivo e atribu�-lo � vari�vel f
			FileOutputStream f = new FileOutputStream(arquivo);
			//Prepara o arquivo para receber entradas
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			//Escreve a lista agenda no arquivo
			o.writeObject(pessoas);
			
			//Desaloca recursos do arquivo criado e retorna para a mem�ria
			o.close();
			o = null;
			f.close();
			f = null;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//Recuperando os objetos do arquivo
		try{
			//Abre o arquivo e atribui � vari�vel f
			FileInputStream f = new FileInputStream(arquivo);
			//Prepara o arquivo para ser lido
			ObjectInputStream o = new ObjectInputStream(f);
			
			//A vari�vel obj do tipo mais gen�rico (Object) recebe o objeto do arquivo
			//Como n�o sei o tipo do objeto que vou receber, deve ser o tipo mais gen�rico
			Object obj = o.readObject();
			
			//A lista agenda recebe o objeto que foi lido do arquivo
			//� necess�rio fazer casting para o tipo a atribuir
			pessoas = (ArrayList<String>)obj;
			
			//Desaloca recursos do arquivo criado e retorna para a mem�ria
			o.close();
			o = null;
			f.close();
			f = null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Validacao
		String nome1 = "Gabriel";
		String nome2 = "Andressa";
		String nome3 = "Jeremias";
		Assert.assertEquals(nome1, pessoas.get(0));
		Assert.assertEquals(nome2, pessoas.get(1));
		Assert.assertEquals(nome3, pessoas.get(2));
	}
}
