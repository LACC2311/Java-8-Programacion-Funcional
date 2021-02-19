package com.lacc2311.lambdas;

public class Lambda {

	public static void main(String[] args) {

		/*
		 *  Clase an�nima 
		 */
		MiNombre miNombreAnonima = new MiNombre() {
			/*
			 *  Sobreescribimos el m�todo de la interface
			 */
			@Override
			public String miNombre() {
				return "Mi nombre es Anibal Anonimo";
			}
		};
		
		System.out.println(miNombreAnonima.miNombre());
		
		/* Funci�n lambda
		 * 
		 * ()	-	Argumentos
		 * ->	-	Operador
		 * "Mi nombre es Anibal Lambda"		-	Cuerpo de la funci�n
		 * 
		 */
		MiNombre miNombreLambda = () -> "Mi nombre es Anibal Lambda";
		
		System.out.println(miNombreLambda.miNombre());
		
	}

}
