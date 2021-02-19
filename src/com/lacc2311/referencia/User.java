package com.lacc2311.referencia;

public class User {
	
	private String nombre;

	public User(String nombre) {
		this.nombre = nombre;
	}
	
	public static void referenciaAMetodoEstatico() {
		System.out.println("Probando referencia a m�todo est�tico");
	}
	
	public void referenciaAMetodoDeInstancia() {
		System.out.println("Probando referencia a m�todo de Instancia");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}

}
