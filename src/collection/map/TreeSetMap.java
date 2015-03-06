/**
 * @author Wesley Egberto de Brito
 * 
 * TreeMap
 * > Classe que implementa NavigableMap (que estende SortedMap);
 * > Armazena os elementos em árvore;
 * > Garante ordenação pela ordem natural dos elementos (método compare de Comparable) ou um Comparator (recebido no construtor);
 * > Os objetos chaves devem implementar Comparable ou deve-se passar um Comparator no construtor;
 * > Mais lento que HashMap;
 * > Garante tempo log(n) para de operação básicas (add, contains e remove);
 * > Não é sincronizada;
 * > Não permite elementos null;
 */
package collection.map;

import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeSetMap {
	public static void main(String[] args) {
		// Animal deve implementar Comparable ou deve passar um Comparator
		// no construtor.
		TreeMap<Animal, String> t = new TreeMap<Animal, String>(
				new StringDescendingSorter());

		t.put(new Animal("A"), "2");
		t.put(new Animal("F"), "4");
		t.put(new Animal("C"), "10");
		t.put(new Animal("Z"), "0");
		t.put(new Animal("Q"), "9");
		// t.put(null, null); NPE
		t.put(new Animal("X"), null);
		t.put(new Animal("S"), null);

		Set<Entry<Animal, String>> entrySet = t.entrySet();
		for (Entry<Animal, String> e : entrySet) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}

class StringDescendingSorter implements Comparator<Animal> {
	@Override
	public int compare(Animal a1, Animal a2) {
		return a1.specie.compareTo(a2.specie);
	}
}

class Animal {
	String specie;

	public Animal(String s) {
		this.specie = s;
	}

	@Override
	public String toString() {
		return "Animal [specie=" + specie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specie == null) ? 0 : specie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (specie == null) {
			if (other.specie != null)
				return false;
		} else if (!specie.equals(other.specie))
			return false;
		return true;
	}

}