package statics;

// Utilização de variáveis estáticas e bloco de inicialização estático
public class MembrosEstaticos {
	static int incremento; // variável estática, é inicializada quando a classe
							// é carregada

	// bloco de inicialização estático, é a primeira coisa que é executado
	// quando a classe é carregada na memória pela JVM
	static {
		System.out.println("Bloco de inicializacao estatico executado!\n");
	}

	// bloco de inicialização, é executado toda vez que um objeto é instânciado,
	// após a chamada super() e antes do resto do construtor
	{
		System.out.println("Bloco de inicializacao executado!\n");
	}

	public MembrosEstaticos() {
		System.out.println("Construtor executado!\n");
	}
}
