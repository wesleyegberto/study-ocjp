/**
 * @author Wesley Egberto de Brito
 * 
 * Hashtable
 * > É sincronizada;
 * > Utiliza internamente um array de Entry;
 * > Não permite chave nem elementos null;
 */

package collection.map;

import java.util.Hashtable;

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

		ht.put("A", 1);
		ht.put("Z", 20);
		// ht.put(null, 30); NPE
		/// ht.put("G", null); NPE
		ht.put("Y", 90);
		
		System.out.println("Hashatable: " + ht);
	}
}
