package pacotes.packageB;

import pacotes.packageA.Message;

public class XMLMessage extends Message {
	// Não sobrecarrega porque o método da superclasse
	// não é visivel aqui (default = pacote)
	// se fosse protected seria visivel
	String getText() {
		// Posso usar x aqui porque é protected
		x = 10;
		
		Message m = new Message();
		// não posso usar aqui porque protected = default + filhos
		// m.x = 20;
		
		return "<msg>text</msg>";
	}

	public static void main(String[] args) {
		System.out.println(new XMLMessage().getText());
	}
}
