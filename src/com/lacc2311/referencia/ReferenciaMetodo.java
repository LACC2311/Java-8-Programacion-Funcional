package com.lacc2311.referencia;

public class ReferenciaMetodo {

	public static void main(String[] args) {
		
//		Referencia a un método estático 	- 	Class::metodoEstatico
		
//		Usando clase anónima
		Trabajo trabajo = new Trabajo() {
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
			}
		};
		trabajo.accion();
		
//		Usando expresión lambda
		Trabajo trabajoL = () -> User.referenciaAMetodoEstatico();
		trabajoL.accion();
		
//		Usando referencia a método (Method Reference)
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		trabajoMR.accion();
		
		
//		Referencia a método de instancia	-	instancia::metodoInstancia
		User user = new User("Anibal");
		
//		Usando expresión lambda
		Trabajo trabajoL2 = () -> user.referenciaAMetodoDeInstancia();
		trabajoL2.accion();
		
//		Usando referencia a método
		Trabajo trabajoMR2 = user::referenciaAMetodoDeInstancia;
		trabajoMR2.accion();

	}

}
