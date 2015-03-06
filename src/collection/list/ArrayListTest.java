/**
 * @author Wesley Egberto de Brito
 * Objetivo: Teste da class ArrayList
 * 
 * > Cresce dinamicamente (cria um novo array e copia todos os itens);
 * > Classe que implementa List e RandomAccess (interface marcadora para informa que possui
 *   rápido acesso aleatório);
 * > Permite elementos null;
 * > Não é sincronizada;
 * > Prove recursos mais poderosos de pesquisa e inserção que arrays;
 */

package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("G");
		list.add("H");

		System.out.printf("Contém G: %b%n%n", list.contains("G"));

		// Iterator contém apenas métodos básicos para navegação
		Iterator<String> it = list.iterator();

		System.out.println("Using Iterator:");
		while (it.hasNext())
			System.out.println(it.next());

		ListIterator<String> listIt = list.listIterator();

		System.out.println("\nAntes do ListIterator: " + list);
		while (listIt.hasNext()) {
			System.out.println("> " + listIt.previousIndex() + " "
					+ listIt.nextIndex());
			// Permite pegar o index atual e também permite adicionar
			if (listIt.nextIndex() == 3) {
				// Adiciona antes do item atual retornado pelo next()
				// a chamada do next() ainda retornará o item atual pois foi
				// adicionado antes
				listIt.add("D");
				System.out.println("> Depois da adição "
						+ listIt.previousIndex() + " " + listIt.nextIndex());
			} else if (listIt.previousIndex() == 4) {
				// Permite alterar o index atual
				listIt.next(); // Consome o atual para substituí-lo
				listIt.set("F");
				System.out.println("> Depois da substituição "
						+ listIt.previousIndex() + " " + listIt.nextIndex());
			}
			System.out.println(listIt.next());
		}
		System.out.println("Final ArrayList: " + list);

		// Convertendo para array (retorna um novo array de Object[] contendo
		// cada elemento)
		System.out.print("\nArray retornado de toArray(): ");
		Object[] arrFromList = list.toArray();
		System.out.println(Arrays.toString(arrFromList));

		// Ordenando o List
		list.add(3, "W");
		list.add(0, "Z");
		System.out
				.println("\nList antes do Collections.sort(List<T>): " + list);
		Collections.sort(list);
		System.out.println("List depois do Collections.sort(List<T>): " + list);
		Collections.sort(list, new StringDescendingSorter());
		System.out.println("List depois do Collections.sort(List<T>, Comparator<T>): "
						+ list);

		// Ordenando objetos de classes sem Comparable
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("M"));
		animals.add(new Animal("A"));
		System.out.println("\nList Animal antes de "
				+ "Collections.sort(List<T>, Comparator<T>): " + animals);
		// Collections.sort(animals); Erro pois Animal não É-UM Comparable
		Collections.sort(animals, new Comparator<Animal>() {
			@Override
			public int compare(Animal a1, Animal a2) {
				return a1.specie.compareTo(a2.specie);
			}
		});
		System.out
				.println("List Animal antes de Collections.sort(List<T>, Comparator<T>): "
						+ animals);
		
		

		list.clear();
		list.add("C"); list.add("D"); list.add("A"); list.add("G");
		System.out.println("\nBusca com Collections.binarySearch(List<T>, T): ");
		// Collections.binarySearch(List<T>, T) tem que receber uma List de objetos
		// que implementam Comparable
		// Pesquisando - a List deve estar ordenada antes de invocar binarySearch() caso
		// contrário o resultado não será previsível ou correto
		// É retornado -1 porque o Array não está ordenado (e -1 significa que o A
		// deveria estar na posição 0)
		System.out.println("Unsorted (" + list + "): 'A' encontrado em: " + Collections.binarySearch(list, "A"));
		Collections.sort(list);
		System.out.println("Sorted (" + list + "): 'A' encontrado em: " + Collections.binarySearch(list, "A"));
		
		// Pesquisando com ordenação descendente
		System.out.println("Ascending (" + list + "): 'G' encontrado em: " + Collections.binarySearch(list, "G"));
		Collections.sort(list, new StringDescendingSorter());
		System.out.println("Descending (" + list + "): 'G' encontrado em: " +
				Collections.binarySearch(list, "G", new StringDescendingSorter()));
	}
}

class StringDescendingSorter implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
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
}
