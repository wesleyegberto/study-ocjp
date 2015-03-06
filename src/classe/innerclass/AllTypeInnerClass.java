package classe.innerclass;

public class AllTypeInnerClass {
	public class Teste {
		private int a;
		protected int b;
		int c;
		//static int d;
		static final int e = 15; // só permite static final
		
		Teste(int x) {
		}
		
		public void m1() {}
		// public static void canNotHaveStaticMethod() {}
	}

	Teste get(final int j) {
		/* Retorna uma classe anônima que estende a Teste */
		return new Teste(j) {
			private int a;
			protected int b;
			int c;
			// static int d;
			static final int e = 15; // só permite static final
			
			int f = j;
			
			public void m1() {}
			// public static void canNotHaveStaticMethod() {}
		};
	}

	static class Teste1 extends AllTypeInnerClass {
		private int a;
		protected int b;
		int c;
		static int d; // static inner class pode ter declarações normais
		static final int e = 15;

		public void m1() {}
		public static void canHaveStaticMethod() {}
	}

	public static void main(String[] args) {
		AllTypeInnerClass ic = new AllTypeInnerClass();

		/*AllTypeInnerClass.*/Teste t = ic.get(3);
	}
}
