package com.lacc2311.lambdas;

// Agregamos anotación para que la interface no permita más de un método abstracto
@FunctionalInterface
public interface Sumar {

	int suma(int a, int b);
	
}
