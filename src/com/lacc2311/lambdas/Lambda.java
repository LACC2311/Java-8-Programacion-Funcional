package com.lacc2311.lambdas;

public class Lambda {

	public static void main(String[] args) {

		/*
		 *  Clase anónima 
		 */
		MiNombre miNombreAnonima = new MiNombre() {
			/*
			 *  Sobreescribimos el método de la interface
			 */
			@Override
			public String miNombre() {
				return "Mi nombre es Anibal Anonimo";
			}
		};
		
		System.out.println(miNombreAnonima.miNombre());
		
		/* Función lambda
		 * 
		 * ()	-	Argumentos
		 * ->	-	Operador
		 * "Mi nombre es Anibal Lambda"		-	Cuerpo de la función
		 * 
		 */
		MiNombre miNombreLambda = () -> "Mi nombre es Anibal Lambda";
		
		System.out.println(miNombreLambda.miNombre());
		
	}

}
