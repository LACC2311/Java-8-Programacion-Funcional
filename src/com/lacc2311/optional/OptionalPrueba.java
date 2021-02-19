package com.lacc2311.optional;

import java.util.Optional;

public class OptionalPrueba {
	
	public static void main(String[] args) {
//		probarOptional(null);
//		orElseOptional(null);
		orElseThrow(null);
		
	}
	
	public static void probarOptional(String nombre) {
		// En caso de mandar un objeto sin inicializar el método length() lanza nullpointer exception
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
		// Se crea un optional vacio
		Optional<String> optional = Optional.empty();
		// Se obtiene el objeto del tipo declarado dentro del operador <>
		optional.get();
	}
	
	public static void orElseOptional(String nombre) {
		// no lanza exepción en caso de llegar nulo
		Optional<String> optional = Optional.ofNullable(nombre);
		// orElse: en caso de que el objeto sea nulo toma el valor por default
		String nombreOfNullable = optional.orElse("default");
		System.out.println(nombreOfNullable);
	}
	
	public static void orElseThrow(String nombre) {
		Optional<String> optional = Optional.ofNullable(nombre);
		optional.orElseThrow(NullPointerException::new);
		String nombre1 = optional.get();
		System.out.println(nombre1);
	}

}
