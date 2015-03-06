package classe.innerclass;

public class OuterInnerStatic {
	private static int x = 3;
	private int y = 10;

	void print() {
		System.out.println("Outer");
		// Inner.this.println("Inner através do Outer");
	}

	static class Inner {
		OuterInnerStatic obj;
		
		Inner(OuterInnerStatic ois) {
			this.obj = ois;
		}
		
		void print() {
			System.out.println(x + " inner " + obj.y);
			// Outer.this.print();
		}
	}

	public static void main(String[] args) {
		OuterInnerStatic.Inner i = new OuterInnerStatic.Inner(new OuterInnerStatic());

		i.print();
	}
}
