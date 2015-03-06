/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar classe LinkedHashSet
 * 
 * > classe que implementa Set;
 * > Igual ao HashSet, porém mantem a ordem de inserção;
 * > armazena os elementos em um hash table como lista lincada (usa internamente um LinkedHashMap);
 * > ordenação pela ordem de inserção;
 * > tempo constante de operação básicas (add, contains e remove), assumindo que a função hash distribuí os elementos
 * 	 apropriadamente nos containers;
 * > tempo de interação é proporcional à quantidade de elementos;
 * > é recomendável ter a capacidade inicial grande (a padrão é 16, muito grande perde tempo na comparação
 *   e muito pequeno perde tempo realocando);
 * > não é sincronizada;
 * > permite elementos null;
 * 
 */

package collection.set;

import java.util.LinkedHashSet;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet h = new LinkedHashSet();

		h.add(12); // Retorna false caso já exista
		h.add(14);
		h.add(50);
		h.add(11);
		h.add(12); // Retorna falso, pois já existe um 12 na fila

		Iterator it = h.iterator();
		int i = 0;

		// A ordem � a mesma que foi inserida
		while(it.hasNext())
			System.out.println(i++ + " => " + it.next());
	}
}
