/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar classe HashSet
 * 
 * > classe que implementa Set;
 * > armazena os elementos em um hash table;
 * > não garante ordenação;
 * > É baseado no valor de hash code e equals;
 * > implementação de maior performance (pois é organizado pelo hash code);
 * > tempo constante de operação básicas (add, contains e remove), assumindo que a função hash distribuí os elementos
 *   apropriadamente nos conteiners;
 * > tempo de interação é proporcional à quantidade de container * a quantidade de elemento por container;
 * > é recomendável ter a capacidade inicial pequena (a padrão é 16, muito grande perde tempo na comparação
 *   e muito pequeno perde tempo realocando);
 * > não é sincronizada;
 * > permite elementos null;
 * > Não permite duplicata nos conjuntos;
 */

package collection.set;

import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class HashSetTest {
	public static void main(String[] args) {
		HashSet h = new HashSet();

		h.add(12); // Retorna false caso já exista
		h.add(14); // Retorna true se for adicionado
		h.add(50);
		h.add(11);
		System.out.println("Add 12 novamente: " + h.add(12) + "\n"); // Retorna falso, pois já existe um 12 na fila

		Iterator it = h.iterator();
		int i = 1;
		while(it.hasNext())
			System.out.println(i++ + "o => " + it.next());
		
		System.out.println();
		HashSet<Animal> animals = new HashSet<Animal>();
		animals.add(new Animal("A"));
		animals.add(new Animal("D"));
		animals.add(new Animal("C"));
		animals.add(new Animal("B"));
		// Permite adicionar pois não foi sobrescrito equals() e hashCode()
		animals.add(new Animal("A"));
		animals.add(new Animal("H"));
		
		Iterator<Animal> iterator = animals.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
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
