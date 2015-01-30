package ordem_inicializacao;

public class OrdemInicializacao extends SuperClass {
	static int i = 2;
	int j = 5;

	static {
		System.out.println("Bloco estatico. i = " + i);
		i = 9;
		System.out.println("Bloco estatico. i = " + i);
	}

	{
		System.out.println("Bloco nao estatico. j = " + j + " e i = " + i);
		j = 4;
		System.out.println("Bloco nao estatico. j = " + j + " e i = " + i);
	}

	public OrdemInicializacao() {
		System.out.println("Construtor. j = " + j + " e i = " + i);
	}

	public static void main(String[] args) {
		new OrdemInicializacao();
	}
}


class SuperClass {
	static {
		System.out.println("Bloco estatico super.");
	}

	{
		System.out.println("Bloco nao estatico super.");
	}
	
	SuperClass() {
		System.out.println("Construtor super.");
	}
}