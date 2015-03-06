package collection.map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {
	public static void main(String[] args) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		
		tm.put("A", 3);
		tm.put("Z", -95);
		tm.put("B", 15);
		tm.put("Q", 5);
		tm.put("Y", -4);
		tm.put("U", 0);
		tm.put("W", 99);
		tm.put("H", 22);
		
		System.out.println("TreeMap: " + tm);
		System.out.println("Reverse TreeMap: " + tm.descendingMap());

		System.out.println();
		NavigableMap<String, Integer> nm = tm;
		
		System.out.println("Valor imediatamente < U: " + nm.lowerKey("U"));
		System.out.println("Valor imediatamente <= U: " + nm.floorKey("U"));
		System.out.println("Valor imediatamente > U: " + nm.higherKey("U"));
		System.out.println("Valor imediatamente >= U: " + nm.ceilingKey("U"));
		
		System.out.println("pollFirst: " + nm.pollFirstEntry());
		System.out.println("pollLast: " + nm.pollLastEntry());
	
		System.out.println();
		

		// headMap("Q") retorna SortedMap
		NavigableMap<String, Integer> nmr = nm.headMap("Q", false);
		System.out.println("headMap(\"Q\", false): " + nmr); // {B=15, H=22}

		nmr = nm.headMap("Q", true);
		System.out.println("headMap(\"Q\", true): " + nmr); // {B=15, H=22, Q=5}

		
		// tailMap("W") retorna SortedMap
		nmr = nm.tailMap("W", false);
		System.out.println("tailMap(\"W\", false): " + nmr); // {Y=-4, Z=-95}
		
		nmr = nm.tailMap("W", true);
		System.out.println("tailMap(\"W\", true): " + nmr); // {W=99, Y=-4, Z=-95}
		
		// subMap("H", "Y") retorna SortedMap (abaixo é equivalente)
		nmr = nm.subMap("H", true, "Y", false);
		System.out.println("ns.subMap(\"H\", true, \"Y\", false): " + nmr); // {H=22, Q=5, U=0, W=99}
		
		nmr = nm.subMap("H", true, "Y", true);
		System.out.println("ns.subMap(\"H\", true, \"Y\", true): " + nmr); // {H=22, Q=5, U=0, W=99}
		

		System.out.println("\n\nBacked collection:");
		// Backed collection: os métodos headSet, tailSet e subSet
		// retornam referências para o range filtrado, assim
		// se alterado na collection original ou na retornada
		// ambas são alteradas (contato que esteja no range da colleciton
		// retornada, senão apenas a collection original será alterada)
		
		nmr = nm.tailMap("Q", true);
		System.out.println("Original: " + nm);
		System.out.println("tailMap(Q, true): " + nmr);
		
		nmr.put("T", 8); // == nm.put("T", 8)
		System.out.println("\nDepois de nmr.put(\"T\", 8): ");
		System.out.println("Original: " + nm);
		System.out.println("tailMap: " + nmr);
		
		nm.put("G", 16); // se for nsr.put("G", 16) é lançada IllegalArgumentExcetion (key out of range)
		System.out.println("\nDepois de nm.put(\"G\", 16): ");
		System.out.println("Original: " + nm);
		System.out.println("tailMap: " + nmr);
		
		nmr.pollFirstEntry();
		System.out.println("\nDepois de nmr.pollFirstEntry(): ");
		System.out.println("Original: " + nm);
		System.out.println("tailMap: " + nmr);
		
		nm.pollFirstEntry();
		System.out.println("\nDepois de nm.pollFirstEntry(); ");
		System.out.println("Original: " + nm);
		System.out.println("tailMap: " + nmr);
	}
}
