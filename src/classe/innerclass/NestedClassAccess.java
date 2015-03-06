package classe.innerclass;

public class NestedClassAccess {
	private int myId = 120;
	private static int commonId = 111;

	private NestedClassAccess() {

	}

	protected NestedClassAccess(int x) {
		myId = x;
	}

	class InnerClass extends NestedClassAccess {
		private int myId = 121;

		public InnerClass() {
			super(122);
		}

		public void get() {
			System.out.println("outer NestedClass ID: " + NestedClassAccess.this.myId);
			System.out.println("super NestedClass ID: " + super.myId);
			System.out.println("InnerClass ID: " + this.myId);
		}
	}

	static class StaticInnerClass {
		public static boolean iCan() {
			return true;
		}

		public int get() {
			return commonId;
		}
	}

	public static void main(String[] args) {
		new NestedClassAccess().new InnerClass().get();
	}
}

class OutterClass2 {
	public void doStuff() {
		NestedClassAccess.InnerClass c;
		c = null;
		System.out.println(c);
	}

}
