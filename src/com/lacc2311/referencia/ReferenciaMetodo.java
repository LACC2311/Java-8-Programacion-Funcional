package com.lacc2311.referencia;

public class ReferenciaMetodo {

	public static void main(String[] args) {
		
//		Referencia a un m�todo est�tico - Class::metodoEstatico
		
//		Usando clase an�nima
		Trabajo trabajo = new Trabajo() {
			
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
			}
		};
		trabajo.accion();
		
//		Usando expresi�n lambda
		Trabajo trabajoL = () -> User.referenciaAMetodoEstatico();
		trabajoL.accion();
		
//		Usando referencia a m�todo (Method Reference)
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		trabajoMR.accion();

	}

}
