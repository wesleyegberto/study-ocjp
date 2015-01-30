package tipos;

public class Wrappers {
	public static void main(String[] args) {
		System.out.println("[Integer]");
		Integer i1 = 10;
		Integer i2 = 10;
		
		System.out.println("Using ==: " + (i1 == i2));
		System.out.println("Using !=: " + (i1 != i2));
		System.out.println("Using equals: " + (i1.equals(i2)));
		System.out.println("Using hashcode: " + (i1.hashCode() == i2.hashCode()));
		
		System.out.println("\n[Short]");
		Short s1 = 32767;
		Short s2 = 32767;
		System.out.println("Using ==: " + (s1 == s2));
		System.out.println("Using !=: " + (s1 != s2));
		System.out.println("Using equals: " + (s1.equals(s2)));
		System.out.println("Using hashcode: " + (s1.hashCode() == s2.hashCode()));
	}
}
