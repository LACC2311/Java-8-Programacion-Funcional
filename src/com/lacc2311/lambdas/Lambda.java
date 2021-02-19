package com.lacc2311.lambdas;

public class Lambda implements PorDefecto {

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
		
//		Clase an�nima
		Sumar suma = new Sumar() {
			
			@Override
			public int suma(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println(suma.suma(5, 3));
		
//		Funci�n lambda
		Sumar suma1 = (a,b) -> a + b;
		System.out.println(suma1.suma(5, 3));
		
//		Podemos escribir funcionalidad extra dentro del cuerpo dentro de { }
		Sumar suma2 = (a,b) -> {
			a = b * b;
			a = a + b;
			System.out.println("Mensaje dentro del lambda");
			return a;
		};
		
		System.out.println(suma2.suma(5, 3));
		
//		Llamado a m�todo por defecto (implementado dentro de la interface)
		Lambda l = new Lambda();
		System.out.println( l.nombrePorDefecto("Anibal") );
		
	}

//	Funci�n sin implementar en la interface
	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
