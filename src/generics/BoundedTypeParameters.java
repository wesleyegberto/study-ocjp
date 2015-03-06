/**
 * Os Bounded Type Parameters são usados para limitar os tipos de objetos que
 * serão adicionados em uma coleção.
 * 
 * Sintaxe:
 *  - Upper: < {nome} extends {Superclass or Interface}>
 *  - Lower: < ? super {Subclasse or interface}>
 * Ex: <E extends Object> <E extends List> List<? super Integer>
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedTypeParameters {
	/**
	 * Upper Bounded Type Recebe um List de elementos Number ou seus subtipos.
	 * Upper bounded é utilizado para leitura, não permite adição de elementos.
	 */
	static <F extends Number> F sort(List<F> list) {
		F f = null;
		
		for(F it : list) {
			it.toString(); // Podemos chamar apenas métodos visíveis para Number. 
		}
		
		return f;
	}

	/**
	 * Upper Bounded Type Equivale a declaração acima, por�m n�o podeá
	 * reutilizar o Type Argument para declação ou retorno
	 */
	static void sort2(List<? extends Number> list) {

	}

	/**
	 * Lower Bounded Type Recebe um List de elementos Number ou seus supertipos.
	 * Utilizado para adição de elementos do tipo C ou seus subtipos.
	 */
	static void sort3(List<? super C> list) {
		// Podemos add A pq ele implementa C, então
		// qulquer List<? super C> poderá receber A
		list.add(new A());
	}

	/**
	 * O Type Parameter L deve estender ou implementar todos os parâmetros
	 * (A, D e C). Se um dos parâmetros for uma classe esta deve ser a primeira
	 * (no caso a classe A) senão dará erro.
	 * Mais utilizado com interfaces.
	 * Pode receber apenas List<A>
	 */
	static <L extends A & D & E> void merge(List<L> list) {
		for(L it : list) {
			
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
		sort(l1);

		// A classe A é subclasse da B que implementa C e D
		List<A> l2 = Arrays.asList(new A(), new A(), new A());
		merge(l2);

		List<C> l3 = Arrays.asList(new C() {
			public void mE() {}
			public void mC() {}
		}, new C() {
			public void mE() {}
			public void mC() {}
		});
		sort3(l3);

		List<Number> lst0 = new ArrayList<Number>();
		List<? extends Number> lst1 = lst0;
		List<? super Integer> lst2 = lst0;
	}
}

interface E {
	public void mE();
}

interface D {
	public void mD();
}

interface C extends E {
	public void mC();
}

class B implements C, D {
	public void mE() {	}

	public void mD() {	}

	public void mC() {	}
}

class A extends B {
}
