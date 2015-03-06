/**
 * @author Wesley Egberto de Brito
 * Objetivo: Teste da class LinkedList
 * 
 * > É eficiente na inserção de itens nas extremidades (Pilha e Fila), porém
 *   tem navegação e localização é ruim;
 * > Permite itens repetidos e null;
 * > Implementa Deque;
 * > Não é sincronizada;
 * > Contém implementação para se comportar como uma Pilha e uma Fila;
 */

package collection.list;

import java.util.ListIterator;
import java.util.List;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		// LIFO/FILO - Stack: push(E), poll()/pop(), peek()
		ll.push("A"); // call addFirst(E)
		ll.push("B");
		ll.push("C");

		ll.add("D"); // add no final da lista, retorna true
		ll.offer("G"); // call add(E)
		ll.addFirst("E"); // chamado pelo push(E)
		ll.addLast("F"); // igual ao add() mas não void e lança exception

		// Retorna um ListIterator posicionado no início da lista para poder
		// navegar na ordem normal (o método previousIndex() nessa posição retorna -1)
		ListIterator<String> li = ll.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}

		// Pega e remove o primeiro elemento (retorna null quando vazia)
		System.out.println("poll: " + ll.poll());
		// Pega o primeiro elemento sem remover (retorna null quando vazia)
		System.out.println("peek: " + ll.peek());
		// Pega e remove o primeiro elemento (Lança NoSuchElementException)
		System.out.println("pop: " + ll.pop());

		// Retorna um ListIterator posicionado no fim da lista para poder
		// navegar na ordem inversa (o método nextIndex() nessa posição retorna
		// o size da lista)
		li = ll.listIterator(ll.size());
		li.hasNext();
		
		LinkedList l = new LinkedList();

		l.add(1);
		l.add(2);
		l.add(2, 5); // Adiciona o Integer(5) na posição 2, se for uma posição
						// fora do array é lançado uma IndexOutOfBoundsException

		System.out.println("Itens full");
		for(int i = 0; i < l.size(); i++)
			System.out.println(i + " => " + l.get(i));

		// Imitando Pilha
		l.pop(); // Retira um item da pilha (do inicio da lista)
		System.out.println("\nItens com 1 pop");
		for(int i = 0; i < l.size(); i++)
			System.out.println(i + " => " + l.get(i));

		l.push(8); // Coloca um item na pilha (no inicio da lista)
		System.out.println("\nItens com 1 push(8)");
		for(int i = 0; i < l.size(); i++)
			System.out.println(i + " => " + l.get(i));

		// Imitando Fila
		l.poll(); // Retira um item na fila (no inicio da lista)
		System.out.println("\nItens com 1 poll");
		for(int i = 0; i < l.size(); i++)
			System.out.println(i + " => " + l.get(i));

		l.offer(18); // Coloca um item na fila (no fim da lista)
		System.out.println("\nItens com 1 offer(18)");
		ListIterator lstIt = l.listIterator();
		while(lstIt.hasNext())
			System.out.println(lstIt.nextIndex() + " => " + lstIt.next());

	}
}
