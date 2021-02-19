package com.lacc2311.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamPrueba {
	
	private static List<User> users;
	
	public static void main(String[] args) {
		setUpUser();
		
		// Dos formas de crear un stream 
		Stream stream = Stream.of(users);
		users.stream();
		
		users.stream().forEach(e->e.setNombre(e.getNombre() + " Apellido"));
		imprimirLista();
		
	}
	
	private static void setUpUser() {
		users = new ArrayList<>();
		users.add(new User(1,"Anibal"));
		users.add(new User(2,"Marta"));
		users.add(new User(3,"Maria"));
		users.add(new User(4,"Pablo"));
		users.add(new User(5,"Adolfo"));
		users.add(new User(6,"Anibal"));
	}
	
	private static void imprimirLista() {
		users.stream().forEach( e -> System.out.println(e.toString()) );
	}

}
