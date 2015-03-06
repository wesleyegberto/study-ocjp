/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar a class HashMap
 * 
 * > Armazena os elementos em um hash table;
 * > Não garante ordenação;
 * > É baseado no valor de hash code e equals;
 * > não é sincronizada;
 * > permite chaves e elementos null;
 * > implementação de maior performance (pois é organizado pelo hash code);
 * > tempo constante de operação básicas (add, contains e remove), assumindo que a função hash distribuí os elementos
 *   apropriadamente nos conteiners;
 * > tempo de interação é proporcional à quantidade de container * a quantidade de elemento por container;
 * > é recomendável ter a capacidade inicial pequena (a padrão é 16, muito grande perde tempo na comparação
 *   e muito pequeno perde tempo realocando);
 */

package collection.map;

import java.util.Iterator;
import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		hm.put("Maria", 3);
		hm.put("Joao", 8);
		hm.put(null, null);
		hm.put("Manuel", 7);
		hm.put("Marcelo", 6);
		hm.put("", 0);

		Iterator<String> it = hm.keySet().iterator();
		String key;
		while(it.hasNext()) {
			key = it.next();
			System.out.println(key + " => " + hm.get(key));
		}

	}
}
