/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar a class LinkedHashMap
 * 
 * 
 * > armazena os elementos em um hash table como lista lincada;
 * > ordenação pela ordem de inserção;
 * > não é sincronizada;
 * > permite elementos null;
 * > tempo constante de operação básicas (add, contains e remove), assumindo que a função hash distribuí os elementos
 * 	 apropriadamente nos containers;
 * > Tempo de interação é proporcional à quantidade de elementos;
 * > É recomendável ter a capacidade inicial grande (a padrão é 16, muito grande perde tempo na comparação
 *   e muito pequeno perde tempo realocando);
 */

package collection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		// Instancia um LinkedHashMap com capacidade inicial de 16 posições,
		// 0.75 de fator de carga e ordem de inserção
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();

		hm.put("Maria", 3);
		hm.put("Joao", 8);
		hm.put("", null);
		hm.put("Roberto", 6);
		hm.put("Manuel", 7);
		hm.put(null, null);

		Iterator<String> it = hm.keySet().iterator();
		String key = null;
		System.out.println("Ordem de insercao, 16 posicoes e fator de carga 0.75:");
		while(it.hasNext()) {
			key = it.next();
			System.out.println(key + " => " + hm.get(key));
		}

		// Instancia um LinkedHashMap com capacidade inicial de 6 posições, 0.5
		// de fator de carga e ordem de frequencia  de acesso
		hm = new LinkedHashMap<String, Integer>(6, 0.5f, true);

		hm.put("Maria", 3);
		hm.put("Joao", 8);
		hm.put("Roberto", 6);
		hm.put("Manuel", 7);

		// Altera a frequencia de acesso dos objetos, ordem de frequencia:
		// Manuel, Roberto, Maria, Joao
		hm.get("Roberto");
		hm.get("Maria");
		hm.get("Manuel");
		hm.get("Maria");
		hm.get("Roberto");
		hm.get("Maria");
		hm.get("Joao");
		hm.get("Joao");

		//it = hm.keySet().iterator();
		//key = null;
		//System.out.println("\nOrdem de frequencia, 4 posicoes e fator de carga 0.5:");
		// Não funciona, pois quando o get() é chamado a ordem é alterada por causa
		// da frequencia de acesso (é lançado um ConcurrentModificationException)
		//while(it.hasNext()) { 
		//	key = it.next();
		//	System.out.println(key + " => " + hm.get(key));
		//}
		
		it = hm.keySet().iterator();
		Iterator<Integer> li = hm.values().iterator();
		key = null;
		System.out.println("\nOrdem de frequencia, 4 posicoes e fator de carga 0.5:");
		while(li.hasNext()) {
			key = it.next();
			System.out.println(key + " => " + li.next());
		}
	}
}
