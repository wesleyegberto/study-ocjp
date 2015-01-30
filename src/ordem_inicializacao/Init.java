package ordem_inicializacao;

public class Init {
	Init(int x) {
		System.out.println("1-arg const");
	}

	Init() {
		System.out.println("no-arg const");
	}

	static {
		System.out.println("1st static init");
	}
	{
		System.out.println("1st instance init");
	}
	{
		System.out.println("2nd instance init");
	}
	static {
		System.out.println("2nd static init");
	}

	public static void main(String[] args) {
		System.out.println("[no-arg const]");
		new Init();
		
		System.out.println("\n[1-arg const]");
		new Init(7);
	}
}
