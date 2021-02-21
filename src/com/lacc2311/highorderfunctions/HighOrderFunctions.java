package com.lacc2311.highorderfunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HighOrderFunctions implements SumarInterfaz {

	public static void main(String[] args) {
		HighOrderFunctions hof = new HighOrderFunctions();
		
		//Función
		System.out.println(hof.suma(2, 3));
		
		//Interface
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
		
		//Interface Function<T, R>
		Function<String, String> convertirMayusculas = e -> e.toUpperCase();
		hof.imprimirMayusculas(convertirMayusculas, "anibal");
		
		//Interface BiFunction<T, U, R>, Interface Predicate<T>
		List<Integer> numeros = Arrays.asList(6, 23, -5, 4, 68, -9, -67, 46);
		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar;
		filtrar = (lista, predicado) ->	
			lista.stream()
				.filter(e -> predicado.test(e))
				.collect(Collectors.toList());
		System.out.println(filtrar.apply(numeros, e -> e > 0));
		
		//Interface Consumer<T>
		List<String> nombres = Arrays.asList("Anibal", "Maria", "Paco");
		hof.filtrar(nombres, e -> System.out.println(e), 6);
		
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
	
	public void filtrar(List<String> lista, Consumer<String> consumer, int maximoCaracteres) {
		lista.stream().filter(logicaPredicado(maximoCaracteres)).forEach(consumer);
	}
	
	public Predicate<String> logicaPredicado(int maximoCaracteres){
		return e -> e.length() < maximoCaracteres;
	}
	
}