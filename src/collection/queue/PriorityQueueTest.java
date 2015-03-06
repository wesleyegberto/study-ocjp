/**
 * @author Wesley Egberto de Brito
 * 
 * Objetivo: Testar a classe PriorityQueue que implementa Queue
 */

package collection.queue;

import java.util.*;

public class PriorityQueueTest {
	public static void main(String... args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		// add ou offer adiciona o elemento na fila
		pq.add(5); // chama offer()
		pq.add(3);
		pq.add(60);
		// pq.offer(null); NPE: não permite nulos
		pq.offer(20);
		
		pq.remove(5); // retorna true se foi removido
		
		while(!pq.isEmpty()) {
			System.out.println(pq.peek()); // Apenas requisita sem remover
			// System.out.println(pq.element()); //Apenas requisita sem remover,
			// lança um NoSuchElementException caso a fila esteja vazia

			pq.poll(); // Requisita e remove o elemento superior, retorn null se
						// a fila estiver vazia
			// pq.remove(); //Requisita e remove o elemento superior, lança um
			// NoSuchElementException caso a fila esteja vazia
		}
	}
}
