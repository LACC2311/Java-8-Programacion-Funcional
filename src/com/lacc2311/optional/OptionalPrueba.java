package com.lacc2311.optional;

import java.util.Optional;

public class OptionalPrueba {
	
	public static void main(String[] args) {
		probarOptional(null);
	}
	
	public static void probarOptional(String nombre) {
//		En caso de mandar un objeto sin inicializar el método length() lanza nullpointer exception
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
//		Se crea un optional vacio
		Optional<String> optional = Optional.empty();
//		Se obtiene el objeto del tipo declarado dentro del operador <>
		optional.get();
	}

}
