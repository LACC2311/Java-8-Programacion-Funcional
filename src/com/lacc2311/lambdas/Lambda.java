package com.lacc2311.lambdas;

public class Lambda implements PorDefecto {

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
		
//		Clase anónima
		Sumar suma = new Sumar() {
			
			@Override
			public int suma(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println(suma.suma(5, 3));
		
//		Función lambda
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
		
//		Llamado a método por defecto (implementado dentro de la interface)
		Lambda l = new Lambda();
		System.out.println( l.nombrePorDefecto("Anibal") );
		
	}

//	Función sin implementar en la interface
	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
