package generics;

public class MetodosGenericos {
	java.util.ArrayList t = new java.util.ArrayList();

	{
		t.add("Opa");
		t.add(3);
	}

	public static <T, V> void shake(T t, V v) {
		System.out.println("In generic method.");
	}
	/* Não compila -> Igual ao shake(Integer, Double)
	public static <T extends Integer, V extends Double> void shake(T t, V v) {
		System.out.println("In method generic.");
	}*/

	public static void shake(Integer i, Double d) {
		System.out.println("In normal method.");
	}

	public static void shake(int i, double d) {
		System.out.println("In primitive normal method.");
	}

	
	public static void main(String[] args) {
		shake(new Integer(3), new Double(2.3));
	}
}
