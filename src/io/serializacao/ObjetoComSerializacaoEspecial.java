package io.serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjetoComSerializacaoEspecial extends PaiNaoSerializavel implements Serializable {
	private static final long serialVersionUID = 4461813133990599912L;

	String name;
	int age = 1;

	// Não será serializado, quando deserializado terão seus valores padrão (0 e null)
	transient ObjetoNaoSerializavel objeto;
	transient double peso = 15.5;

	ObjetoComSerializacaoEspecial() {
		System.out.println("ObjetoComSerializacaoEspecial construtor");
	}

	@Override
	public String toString() {
		return "ObjetoComSerializacaoEspecial [name=" + name + ", age=" + age + ", peso=" + peso + ", objeto.tipo="
				+ objeto.tipo + ", super.super.heranca=" + heranca + ", super.familia=" + familia + "]";
	}

	private void writeObject(ObjectOutputStream os) { // throws IOException {
		try {
			// quando chamado dentro do writeObject() ele pede para fazer a
			// serialização normalmente
			os.defaultWriteObject();
			// grava o tipo no final
			os.writeUTF(objeto.tipo);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) { // throws IOException,
													// ClassNotFoundException {
		try {
			// quando chamado dentro do writeObject() ele pede para fazer a
			// deserialização normalmente
			is.defaultReadObject();
			// lê o tipo salvo no final
			String tipo = is.readUTF();
			this.objeto = new ObjetoNaoSerializavel();
			this.objeto.tipo = tipo;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjetoComSerializacaoEspecial bar = new ObjetoComSerializacaoEspecial();
		bar.heranca = 100240.0;
		bar.familia = 10;
		bar.name = "Teste";
		bar.age = 13;
		bar.peso = 33.5;
		bar.objeto = new ObjetoNaoSerializavel();
		bar.objeto.tipo = "Tipo A";

		System.out.println("Antes: " + bar  + "\n");

		FileOutputStream fos = new FileOutputStream("obj1.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bar);
		oos.close();

		bar = null;

		FileInputStream fis = new FileInputStream("obj1.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		bar = (ObjetoComSerializacaoEspecial) ois.readObject();
		ois.close();

		System.out.println("Depois: " + bar);
	}
}

class PaiNaoSerializavel extends AvoSerializavel implements Serializable {
	private static final long serialVersionUID = -8553236443829476294L;
	
	int familia = 3;

	PaiNaoSerializavel() {
		System.out.println("PaiNaoSerializavel construtor");
	}
}

class AvoSerializavel { // implements Serializable {
	double heranca = 100.0;
	
	/**
	 * O construtor do pai não serializável é chamado quando não implementa Serializable.
	 * E todos os construtores das superclasses, pois este chama o outros com super().
	 */
	AvoSerializavel() {
		System.out.println("AvoSerializavel construtor");
	}
}

class ObjetoNaoSerializavel {
	String tipo;

	ObjetoNaoSerializavel() {
		System.out.println("ObjetoNaoSerializavel construtor");
	}
}
