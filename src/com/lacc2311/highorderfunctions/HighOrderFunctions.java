package com.lacc2311.highorderfunctions;

import java.util.function.Function;

public class HighOrderFunctions implements SumarInterfaz {

	public static void main(String[] args) {
		HighOrderFunctions hof = new HighOrderFunctions();
		
		//Función
		System.out.println(hof.suma(2, 3));
		
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
		
		//Versión mejorada con lambda
		SumarInterfaz sumarIntLambda = (a, b) -> a + b;
		System.out.println(hof.sumaHighOrderFun(sumarIntLambda, 2, 6));
		
		//Interfaz funcional Function<T t, R t>
		Function<String, String> convertirMayusculas = e -> e.toUpperCase();
		hof.imprimirMayusculas(convertirMayusculas, "anibal");
		
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
	
	//Function<Parametro de entrada, Retorno de la función>
	public void imprimirMayusculas(Function<String, String> function, String nombre) {
		System.out.println(function.apply(nombre));
	}
	
}