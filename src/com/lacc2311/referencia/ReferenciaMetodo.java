package com.lacc2311.referencia;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;

public class ReferenciaMetodo {

	public static void main(String[] args) {
		
/*
 * 		Referencia a un método estático
 * 		Class::metodoEstatico
 */
		
		// Usando clase anónima
		Trabajo trabajo = new Trabajo() {
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
			}
		};
		trabajo.accion();
		
		// Usando expresión lambda
		Trabajo trabajoL = () -> User.referenciaAMetodoEstatico();
		trabajoL.accion();
		
		// Usando referencia a método (Method Reference)
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		trabajoMR.accion();
		
		
/*
 * 		Referencia a método de instancia
 * 		instancia::metodoInstancia
 */
		User user = new User("Anibal");
		
		// Usando expresión lambda
		Trabajo trabajoL2 = () -> user.referenciaAMetodoDeInstancia();
		trabajoL2.accion();
		
		// Usando referencia a método
		Trabajo trabajoMR2 = user::referenciaAMetodoDeInstancia;
		trabajoMR2.accion();
		
/*
 * 		Referencia a un método de instancia de un objeto arbitrario
 * 		Class::metodoInstancia		
 */
		
		// Lambda
		TrabajoString trabajoStringL = (palabra) -> palabra.toUpperCase();
		System.out.println( trabajoStringL.accion("lambda") );
		
		// Method reference
		TrabajoString trabajoStringMR = String::toUpperCase;
		System.out.println( trabajoStringMR.accion("method reference") );
		
		List<User> users = new ArrayList<>();
		users.add(new User("Anibal"));
		users.add(new User("Hugo"));
		users.add(new User("Paco"));
		users.add(new User("Luis"));
		// Lambda
		users.forEach(nombre -> nombre.mostrarNombre());
		// Method reference
		users.forEach(User::mostrarNombre);
		
/*
 * 		Referencia a un constructor
 * 		Class::new
 */
		
		// Clase anónima
		IUser iUser = new IUser() {
			@Override
			public User crear(String nombre) {
				return new User(nombre);
			}
		};
		iUser.crear("Usuario Anonimo").mostrarNombre();
			
		// Lambda
		IUser iUserL = (nombre -> new User(nombre));
		iUserL.crear("Usuario Lambda").mostrarNombre();
		
		// Referencia a constructor
		IUser iUserRC = User::new;
		iUserRC.crear("Usuario Referencia").mostrarNombre();
		

	}

}
