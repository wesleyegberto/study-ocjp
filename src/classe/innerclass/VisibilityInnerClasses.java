package classe.innerclass;

public class VisibilityInnerClasses {
	
	public static void main(String[] args) {
		new VisibilityInnerClasses().go();
	}
	
	void go() {
		new C().m();
		
		class C {
			public void m() {
				System.out.println("Method Inner C.m");
			}
		}

		new C().m();
		// todas abaixo resultam em "Inner C.m"
		this.new C().m();
		VisibilityInnerClasses.this.new C().m();
		new VisibilityInnerClasses.C().m();
		//new VisibilityInnerClasses.this.C().m();
	}
	
	class C {
		public void m() {
			System.out.println("Inner C.m");
		}
	}
}

class C {
	public void m() {
		System.out.println("Outer C.m");
	}
}