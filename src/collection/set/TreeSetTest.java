/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar a classe TreeSet e a interface NavigableSet TreeSet
 * 
 * > classe que implementa NavigableSet (que estende SortedSet);
 * > armazena os elementos em árvore (usa internamente um TreeMap);
 * > garante ordenação pela ordem natural dos elementos (método compare de Comparable) ou um Comparator (recebido no construtor);
 * > mais lento que HashSet;
 * > garante tempo log(n) para de operação básicas (add, contains e remove);
 * > não é sincronizada;
 * > não permite elementos null;
 * > ou utiliza a comparação natural do objeto com o método compareTo da interface java.lang.Comparable que deve ser implementada,
 *   quando tentado adicionar um objeto que não implementa é lançado um ClassCastException;
 * > ou utiliza um objeto que implemente java.lang.Comparator que é recebido no construtor;
 * > mantem os objetos ordenados e não permite duplicatas;
 */

package collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class TreeSetTest {
	static public void main(String[] args) {
		// É utilizado o ordenador natural (método compareTo() da interface
		// Comparable que a classe Integer implementa)
		TreeSet t = new TreeSet<Integer>();

		t.add(30);
		t.add(20);
		t.add(21);
		t.add(10);

		Iterator it = t.iterator();
		int i = 1;
		System.out.println("Utilizando o natural:");
		while(it.hasNext())
			System.out.println("\t" + i++ + "o => " + it.next());

		// É utilizado o objeto comparador recebido
		t = new TreeSet<Integer>(new IntegerDescendingComparator());

		t.add(30);
		t.add(12);
		t.add(12);
		t.add(21);
		t.add(22);
		// t.add(null); Não aceita, NullPointerException no compare() ou compareTo()

		it = t.iterator();
		i = 1;
		System.out.println("\n\nUtilizando o Comparator:");
		while(it.hasNext())
			System.out.println("\t" + i++ + "o => " + it.next());
		
	}
}

class IntegerDescendingComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;

		return i2 - i1;
	}
}
