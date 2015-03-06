package collection.set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		t.add(3);
		t.add(-95);
		t.add(15);
		t.add(5);
		t.add(-4);
		t.add(0);
		t.add(99);
		t.add(22);
		
		System.out.println("TreeSet: " + t); //[-95, -4, 0, 3, 5, 15, 22, 99]
		System.out.println("Reverse TreeSet: " + t.descendingSet());

		System.out.println();
		NavigableSet<Integer> ns = t;
		
		System.out.println("Valor imediatamente < 3: " + ns.lower(3));
		System.out.println("Valor imediatamente <= 3: " + ns.floor(3));
		System.out.println("Valor imediatamente > 3: " + ns.higher(3));
		System.out.println("Valor imediatamente >= 3: " + ns.ceiling(3));
		
		System.out.println("pollFirst: " + ns.pollFirst());
		System.out.println("pollLast: " + ns.pollLast());
		
		System.out.println();
		
		// headSet(3) retorna SortedSet
		NavigableSet<Integer> nsr = ns.headSet(5, false);
		System.out.println("headSet(3, false): " + nsr); // [-4, 0, 5]

		nsr = ns.headSet(3, true);
		System.out.println("headSet(3, true): " + nsr); // [-4, 0, 3, 5]

		
		// tailSet(5) retorna SortedSet
		nsr = ns.tailSet(5, false);
		System.out.println("tailSet(3, false): " + nsr); // [15, 22]
		
		nsr = ns.tailSet(5, true);
		System.out.println("tailSet(3, true): " + nsr); // [5, 15, 22]
		
		// subSet(0, 15) retorna SortedSet (abaixo é equivalente)
		nsr = ns.subSet(0, true, 15, false);
		System.out.println("ns.subSet(0, true, 22, false): " + nsr); // [0, 3, 5, 15]
		
		nsr = ns.subSet(0, true, 15, true);
		System.out.println("ns.subSet(0, true, 22, true): " + nsr); // [0, 3, 5, 15, 22]
		
		
		System.out.println("\n\nBacked collection:");
		// Backed collection: os métodos headSet, tailSet e subSet
		// retornam referências para o range filtrado, assim
		// se alterado na collection original ou na retornada
		// ambas são alteradas (contato que esteja no range da colleciton
		// retornada, senão apenas a collection original será alterada)
		
		nsr = ns.headSet(10, true);
		System.out.println("Original: " + ns);
		System.out.println("headSet: " + nsr);
		
		nsr.add(8); // == ns.add(8)
		System.out.println("\nDepois de nsr.add(8): ");
		System.out.println("Original: " + ns);
		System.out.println("headSet: " + nsr);
		
		ns.add(16); // se for nsr.add(16) é lançada IllegalArgumentExcetion (out of range)
		System.out.println("\nDepois de ns.add(16): ");
		System.out.println("Original: " + ns);
		System.out.println("headSet: " + nsr);
		
		nsr.pollLast(); // != ns.pollLast(), pq como é headSet o último elemento de nsr será != do último de ns
		System.out.println("\nDepois de nsr.pollLast();: ");
		System.out.println("Original: " + ns);
		System.out.println("headSet: " + nsr);
		
		ns.pollLast();
		System.out.println("\nDepois de ns.pollLast();: ");
		System.out.println("Original: " + ns);
		System.out.println("headSet: " + nsr);

	}
}
