/**
 * @author Wesley Egberto de Brito
 * 
 * Map
 * > Armazena pares de valores: chave-valor
 * > Não permite chaves iguais
 * > Três classes a implementa: HashMap, TreeMap e LinkedHashMap (as 3 com performance similar aos Set's)
 * > Hashtable foi modificada para implementá-la
 * > fornece navegação via Enumeration
 * > permite iterar pelas keys, values ou keys-values (exceto Hashtable)
 * > permite remover itens na iteração de forma seguro (exceto Hashtable)
 * > Map fornece métodos para verificar se a key ou value existe na coleção, o Hashtable fornece apenas para key
 * > Hashtable é sincronizada e as outras não
 * 
 *  
 *  
 * Hashtable
 * > É sincronizada;
 * > Utiliza internamente um array de Entry;
 * > Não permite chave nem elementos null;
 *  
 * 
 * HashMap
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
 * > permite chaves e elementos null;
 * 
 * 
 * 
 * TreeMap
 * > Classe que implementa NavigableMap (que estende SortedMap);
 * > Armazena os elementos em árvore;
 * > Garante ordenação pela ordem natural dos elementos (método compare de Comparable) ou um Comparator (recebido no construtor);
 * > Os objetos chaves devem implementar Comparable ou deve-se passar um Comparator no construtor;
 * > Mais lento que HashMap;
 * > Garante tempo log(n) para de operação básicas (add, contains e remove);
 * > Não é sincronizada;
 * > Não permite chave null;
 * 
 * 
 * 
 * LinkedHashMap
 * > armazena os elementos em um hash table como lista lincada;
 * > ordenação pela ordem de inserção;
 * > tempo constante de operação básicas (add, contains e remove), assumindo que a função hash distribuí os elementos
 * 	 apropriadamente nos containers;
 * > tempo de interação é proporcional à quantidade de elementos;
 * > é recomendável ter a capacidade inicial grande (a padrão é 16, muito grande perde tempo na comparação
 *   e muito pequeno perde tempo realocando);
 * > não é sincronizada;
 * > permite elementos null;
 */
package collection.map;

public class MapInfo {
	public static void main(String[] args) {
		
	}
}
