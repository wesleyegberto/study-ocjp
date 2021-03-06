/**
 * Copyright (c) 2010-2013, BSE Technology. All rights reserved. BSE Technology.
 * Use is subject to license terms.
 * 
 * @author Wesley Egberto de Brito 04/05/2013
 * 
 */
package tipos;

public class TiposBasicos {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * Ordem Crescente dos Tipos byte -> short -> int -> float -> double
		 */
		byte byteMin = -128;
		byte byteMax = 127;
		
		short shortMin = -32768;
		short shortMax = 32767;

		int intMin = -2147483648;
		int intMax = 2147483647;

		char charMin = 0;
		char charMax = 65535;
		char b = 'c';
		char c = 23; // armazenar� o caractere ASCII representado pelo 23
		b += c;
		
		
		/*
		 * Arrays
		 */
		int[] d = new int[3];
		d[0] = 2;

		int[][] e = new int[3][3];
		e[0] = new int[3];
		e[1][0] = 1;

		int[] f = new int[] { 1, 2, 3, 4, 5 };
		int[] g = { 1, 2, 3, 4, 5 };
		// int[] h = new int[5]{1,2,3,4,5}; declara��o inv�lida
		// array de duas dimens�es
		int[] i[] = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }; 
		int[][] j[][]; // array de 4 dimens�es

		
		/*
		 * Atribui��o em arrays
		 */
		//char[] charArr = new char[3];
		//int[] intArr = charArr; n�o funciona
		Double[] doubles = new Double[3];
		Number[] numeros = doubles;
		numeros[0] = Integer.valueOf("4");
	}
}
