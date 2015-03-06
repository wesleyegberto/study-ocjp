package classe.innerclass;

public class TesteInnerMethod {
	private int x = 2;
	
	private static int z;
	
	public static void innerStaticTeste() {
		final int h = 9;
		class Inner {
			private void method() {
				System.out.println("Acessando private static: " + z);
			}
			
			private void giveMe(TesteInnerMethod o) {
				System.out.println("Acessando private int x: " + o.x );
			}
		}
		
		new Inner().method();
	}

	public void innerTeste() {
		final int y = 9;
		int z = 3;
		
		abstract class AbstractInner {}
		final class Inner extends AbstractInner {
			private void print() {
				System.out.println("Inner in method " + TesteInnerMethod.this.x);
				// System.out.println(z); //Erro: pois no final do método z
				// sairá de escopo, e a instância de Inner ainda poderá estar viva no heap
				
				// Permitido, pois a variável z é final e
				// o compilador vai cuidar disso com antecedência
				System.out.println(y); 
			}

			static final int x = 12;

			String y = "Teste";
		}

		Inner i = new Inner();

		i.print();

	}
}

class Teste {
	public static void main(String args[]) {
		TesteInnerMethod t = new TesteInnerMethod();

		t.innerTeste();
	}
}
