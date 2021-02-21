package com.lacc2311.highorderfunctions;

public class HighOrderFunctions implements SumarInterfaz {

	public static void main(String[] args) {
		HighOrderFunctions hof = new HighOrderFunctions();
		
		//Función
		System.out.println(hof.suma(2,3));
		
		//Interfaz
		System.out.println(hof.apply(2, 4));
		
		//High Order Functions
		SumarInterfaz sumarInterfaz = new SumarInterfaz() {
			@Override
			public int apply(int a, int b) {
				return a + b;
			}
		};
		System.out.println(hof.sumaHighOrderFun(sumarInterfaz, 2, 5));
		
		//Versió mejorada con lambda
		SumarInterfaz sumarIntLambda = (a,b) -> a + b;
		System.out.println(hof.sumaHighOrderFun(sumarIntLambda, 2, 5));
		
	}
	
	public int suma(int a, int b) {
		return a + b;
	}

	@Override
	public int apply(int a, int b) {
		return a + b;
	}
	
	//Las HOF pueden recibir como parámetro una función, o retornar una función
	public int sumaHighOrderFun(SumarInterfaz sumar, int a, int b) {
		return sumar.apply(a, b);
	}

}

