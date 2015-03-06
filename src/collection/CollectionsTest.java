/**
 * @author Wesley Egberto de Brito Objetivo: Testar os métodos da classe
 *         Collections
 */

package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class CollectionsTest {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(21);
		l.add(200);
		l.add(12);
		l.add(0);
		l.add(-220);

		ListIterator li = l.listIterator();
		int i = 0;
		System.out.println("Ordem original");
		while(li.hasNext())
			System.out.println("\t[" + i++ + "] => " + li.next());

		li = l.listIterator();
		i = 0;
		Collections.sort(l);
		System.out.println("\nApos Collections.sort()");
		while(li.hasNext())
			System.out.println("\t[" + i++ + "] => " + li.next());
		
		System.out.println();
		List<String> list = new ArrayList<String>();
		list.add("V"); list.add("K"); list.add("Q"); list.add("W");
		
		Comparator<String> reverseOrderReturn = Collections.reverseOrder(new StringDescendingSorter());
		Comparator<Object> reverseOrderDefault = Collections.reverseOrder();
		
		
		Collections.sort(list, reverseOrderReturn);
		System.out.println("Collections.reverseOrder(new StringDescendingSorter()): " + list);
		
		Collections.sort(list, reverseOrderDefault);
		System.out.println("Collections.reverseOrder(): " + list);
		
		Collections.reverse(list);
		System.out.println("Collections.reverse(list): " + list);
	}
}

class StringDescendingSorter implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
}
