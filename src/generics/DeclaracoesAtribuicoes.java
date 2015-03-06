package generics;

import java.util.ArrayList;
import java.util.List;

public class DeclaracoesAtribuicoes {
	public static void main(String[] args) {
		List<?> l1 = new ArrayList<Object>();
		l1 = new ArrayList<Number>();
		l1.add(null);
		//l1.add(4);
		//l1.add(new Object());

		List<Object> l2 = new ArrayList<Object>();
		l2.add(3);
		l2.add("$");
		//l2 = l1;
		
		List<? extends Number> l3 = new ArrayList<Integer>();
		//l3.add(4);
		//l3.add(2.2);
		l3.add(null);
		l3 = new ArrayList<Double>();
		
		List<? super Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		//l4.add(4.2);
		l4.add(Integer.MIN_VALUE);
		l4.add(null);
		
		l4 = new ArrayList<Number>();
		l4.add(4);
		l4.add(null);
		
		l4 = new ArrayList<Object>();
		l4.add(4);
		l4.add(null);
		//l4 = new ArrayList<Double>();
		
		List l5 = new ArrayList<Integer>();
		l5.add(5);
		l5.add("F");
		l5.addAll(l1);
		// quando iterar pelo l5 ocorrerá um ClassCastExecption (por causa do "F")
		l5 = l1;
		l5 = l4;
	}
}
