package classe.sobrecarga;

public class SobrecargaMetodosWrapper {

	static void m1(int i) {
		System.out.println("int");
	}
	
	static void m1(long l) {
		System.out.println("long");
	}
	
	static void m1(Integer i) {
		System.out.println("Integer");
	}
	
	static void m1(Double d) {
		System.out.println("Double");
	}
	
	static void m1(short s1, short s2) {
		System.out.println("short, short");
	}
	
	static void m1(Byte s1, Byte s2) {
		System.out.println("Byte, Byte");
	}
	
	static void m1(byte ... bs) {
		System.out.println("byte ...");
	}
	
	
	public static void main(String[] args) {
		m1(3);
		//m1(3.3f); não consegue efetuar cast e boxing
		m1(3.3);
		m1((short) 3);
		
		byte b1 = 2, b2 = 3;
		m1(b1, b2);
		
		
		m2((byte) 3);
		
		m3(3, 5);
		m4(5, 5);
	}
	
	
	static void m2(Short s) {
		System.out.println("Short");
	}
	
	static void m2(Integer i) {
		System.out.println("Integer");
	}
	
	static void m2(Number n) {
		System.out.println("Number");
	}
	
	static void m3(int ... i) {
		System.out.println("int ...");
	}
	
	static void m4(Integer ... i) {
		System.out.println("Integer ...");
	}
}
