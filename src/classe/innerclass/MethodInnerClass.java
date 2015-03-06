package classe.innerclass;

public class MethodInnerClass {
	float f = 1.3f;

	public void test(int num, final int num2) {
		final int num3 = num;
		class Teste {
			// O compilador cria uma variável oculta (disponível apenas em
			// codigo de máquina, isso deixa uma grande falha.)
			public void print() {
				System.out.println(num2 + " - " + num3);
			}
		}

		Teste t = new Teste();
		t.print();
		System.out.println(num);
	}

	public static void main(String[] args) {
		new MethodInnerClass().test(2, 3);
	}
}
