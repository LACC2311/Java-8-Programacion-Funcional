package com.lacc2311.streams;

import java.util.ArrayList;
import java.util.Arrays;
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
				.filter(e -> !e.getNombre().equals("Anibal"))
				.filter(e -> e.getId() < 3)
				.collect(Collectors.toList());
		usersFilter.stream().forEach( e->System.out.println(e.toString()) );
		
		//Find first
		System.out.println("======================== Find first ========================");
		setUpUser(); //se recarga la lista original
		
		//Obtiene el primer elemento que cumpla con el criterio, en caso de no encontrar alguno devuelve nulo
		User user = users.stream()
				.filter( e->e.getNombre().equals("Anibal") )
				.findFirst()
				.orElse(null);
		
		System.out.println(user.toString());
		
		//flatMap
		System.out.println("======================== Flat map ========================");
		setUpUser(); //se recarga la lista original
		
		//Creamos una lista de listas
		List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Anibal", "Maria", "Pedro")),
						new ArrayList<String>(Arrays.asList("Monica", "Pablo"))
						)
				);
		
		//Unimos todos los datos en una s�la lista
		List<String> nombresUnicaLista = nombresVariasListas.stream()
				.flatMap(e->e.stream())
				.collect(Collectors.toList());
		
		nombresUnicaLista.stream().forEach( e -> System.out.println(e) );
		
		//Peek es un m�todo intermedio a diferencia de forEach que es un m�todo final
		System.out.println("======================== Peek ========================");
		setUpUser();
		
		List<User> userPeek = users.stream()
				.peek( e -> e.setNombre(e.getNombre() + " Peek") )
				.collect(Collectors.toList());
		userPeek.stream().forEach( e -> System.out.println(e.toString()) );
		
		//Count
		System.out.println("======================== Count ========================");
		setUpUser();
		
		long numeroFiltrado = users.stream()
				.filter(e -> e.getId()<3)
				.count();
		System.out.println(numeroFiltrado);
		
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
