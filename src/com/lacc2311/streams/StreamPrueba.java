package com.lacc2311.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
		
		//Map y Collectors.toList
		List <String> lista = users.stream().map(e->e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e->System.out.println(e));
		
		//Filter
		System.out.println("======================== Filters ========================");
		
		setUpUser(); //se recarga la lista original
		
		//Filtramos todos los usaurios que no sean Anibal y el id sea menor a 3
		List<User> usersFilter = users.stream()
				.filter(e -> e.getNombre()!="Anibal")
				.filter(e -> e.getId() < 3)
				.collect(Collectors.toList());
		usersFilter.stream().forEach( e->System.out.println(e.toString()) );
		
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
