package collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
	public static void main(String... args) {
		int[] i = new int[4];

		for (int x = 0; x < 4; x++)
			i[x] = x * 2;

		for (int y : i)
			System.out.print(y + " ");
		System.out.println("\n");

		int[] z = Arrays.copyOfRange(i, 1, 3);

		for (int y : z)
			System.out.print(y + " ");
		System.out.println("\n");


		List<Integer> iL = new ArrayList<Integer>();
		for (int x = 0; x < 3; x++)
			iL.add(x);
		Object[] oa = iL.toArray();
		Integer[] ia2 = new Integer[3];
		ia2 = iL.toArray(ia2);
		
		
		
		Integer[] f = new Integer[] { 51, 72, 65, 84, 98, 84, 485 };

		// Retorna o List como o array no backed list (as alterações de um
		// serão refletidas no outro) de tamanho fixo
		List<Integer> list = Arrays.asList(f);
		f[0] = 20;
		list.set(6, 40);

		List<int[]> listInts = Arrays.asList(new int[] { 20, 30, 40 });

		System.out.println("Array: " + Arrays.toString(f));
		System.out.println("List: " + list);

		System.out.println("\nPesquisa com Arrays.binarySearch(T[], T):");
		System.out.println("Unsorted (" + Arrays.toString(f) + "): '84' encontrado em: " +
				Arrays.binarySearch(f, 84));
		Arrays.sort(f);
		System.out.println("Sorted (" + Arrays.toString(f) + "): '84' encontrado em: " +
				Arrays.binarySearch(f, 84));
	}
}
