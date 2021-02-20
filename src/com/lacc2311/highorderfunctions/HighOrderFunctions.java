package com.lacc2311.highorderfunctions;

public class HighOrderFunctions implements SumarInterfaz {

	public static void main(String[] args) {
		HighOrderFunctions hof = new HighOrderFunctions();
		
		//Función tradicional
		System.out.println(hof.suma(2,3));
		System.out.println(hof.apply(2, 4));
		
	}
	
	public int suma(int a, int b) {
		return a + b;
	}

	@Override
	public int apply(int a, int b) {
		return a + b;
	}

}
