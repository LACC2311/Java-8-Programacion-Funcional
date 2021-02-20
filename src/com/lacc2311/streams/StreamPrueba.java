package com.lacc2311.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrueba {
	
	private static List<User> users;
	
	public static void main(String[] args) {
		setUpUser();
		
		// Dos formas de crear un stream 
		Stream stream = Stream.of(users);
		users.stream();
		
		//Recorremos el collection y agregamos el Apellido
		users.stream().forEach(e ->
			e.setNombre(e.getNombre().concat(" Apellido"))
		);
		imprimirLista();
		
		//Map y Collectors.toList
		List <String> lista = users.stream().map(e -> e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e -> System.out.println(e));
		
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
		setUpUser();
		
		//Obtiene el primer elemento que cumpla con el criterio, en caso de no encontrar alguno devuelve nulo
		User user = users.stream()
			.filter(e -> e.getNombre().equals("Anibal"))
			.findFirst()
			.orElse(null);
		System.out.println(user.toString());
		
		//flatMap
		System.out.println("======================== Flat map ========================");
		setUpUser();
		
		//Creamos una lista de listas
		List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
			Arrays.asList(
				new ArrayList<String>(Arrays.asList("Anibal", "Maria", "Pedro")),
				new ArrayList<String>(Arrays.asList("Monica", "Pablo"))
			)
		);
		
		//Unimos todos los datos en una sóla lista
		List<String> nombresUnicaLista = nombresVariasListas.stream()
			.flatMap(e -> e.stream())
			.collect(Collectors.toList());
		nombresUnicaLista.stream().forEach(e -> System.out.println(e));
		
		//Peek es un método intermedio a diferencia de forEach que es un método final
		System.out.println("======================== Peek ========================");
		setUpUser();
		
		List<User> userPeek = users.stream()
			.peek(e -> e.setNombre(e.getNombre().concat(" Peek")))
			.collect(Collectors.toList());
		userPeek.stream().forEach(e -> System.out.println(e.toString()));
		
		//Count
		System.out.println("======================== Count ========================");
		setUpUser();
		
		long numeroFiltrado = users.stream()
			.filter(e -> e.getId()<3)
			.count();
		System.out.println(numeroFiltrado);
		
		//Skip y Limit
		System.out.println("======================== Skip y Limit ========================");
		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		
		List<String> abcFilter = Arrays.stream(abc)
			.skip(2) //omitimos los 2 primeros elementos
			.limit(4) //limitamos la lista a 4 elementos
			.collect(Collectors.toList());	
		abcFilter.stream().forEach(e -> System.out.println(e));
		
		//Sorted
		System.out.println("======================== Sorted ========================");
		setUpUser();
		
		users = users.stream()
			.sorted(Comparator.comparing(User::getNombre))//Usamos la referencia a método
			.collect(Collectors.toList());
		imprimirLista();
		
		//Min y Max
		System.out.println("======================== Min y Max ========================");
		setUpUser();
		
		User userMin = users.stream()
			.min(Comparator.comparing(User::getId))
			.orElse(null);
		System.out.println(userMin.getId());
		
		User userMax = users.stream()
			.max(Comparator.comparing(User::getId))
			.orElse(null);
		System.out.println(userMax.getId());
		
		//Distinct
		System.out.println("======================== Distinct ========================");
		String[] abc1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "a", "c"};
		
		List<String> abcFilter1 = Arrays.stream(abc1)
			.distinct() //elimina elementos repetidos
			.collect(Collectors.toList());
		abcFilter1.stream().forEach(e -> System.out.println(e));
		
		//allMatch, anyMatch, noneMatch
		System.out.println("======================== allMatch, anyMatch, noneMatch ========================");
		List<Integer> listaNumeros = Arrays.asList(100,300,900,500);
		
		//Verifica si el prédicado es verdadero
		boolean allMatch = listaNumeros.stream().allMatch(e -> e > 301);
		System.out.println(allMatch);
		
		//Verifica si almenos un valor del prédicado es verdadero
		boolean anyMatch = listaNumeros.stream().anyMatch(e -> e > 301);
		System.out.println(anyMatch);
		
		//Verifica si ningún elemento cumple con el predicado
		boolean noneMatch = listaNumeros.stream().noneMatch(e -> e > 10000);
		System.out.println(noneMatch);
		
		//Sum Average Range
		System.out.println("======================== Sum Average Range ========================");
		setUpUser();
		
		double result = users.stream()
			.mapToInt(User::getId)
			.average() //nos da el promedio de la lista
			.orElse(0);
		System.out.println(result);
		
		result = users.stream()
			.mapToInt(User::getId)
			.sum(); //suma todos los elementos
		System.out.println(result);
		
		System.out.println(IntStream.range(0, 100).sum()); //suma todos los enteros dentro del rango
		
		//Reduce
		System.out.println("======================== Reduce ========================");
		setUpUser();
		
		int numero = users.stream()
			.map(User::getId)
			.reduce(100, Integer::sum); //comienza desde 100 y realiza la sumatoria
		System.out.println(numero);
		
		//Joining
		System.out.println("======================== Joining ========================");
		setUpUser();
		
		String names = users.stream()
			.map(User::getNombre)
			.collect(Collectors.joining(" - ")) //concatena los nombres separados por un guion medio
			.toString();
		System.out.println(names);
		
		//toSet
		System.out.println("======================== toSet ========================");
		setUpUser();
		
		//Acumula los elementos de entrada, no garantiza que el orden de elementos sea el mismo que de entrada, garantiza que no habrá elementos repetidos
		Set<String> setNames = users.stream()
			.map(User::getNombre)
			.collect(Collectors.toSet());
		setNames.stream().forEach(e -> System.out.println(e));
		
		//summarizingDouble
		System.out.println("======================== summarizingDouble ========================");
		setUpUser();
		
		DoubleSummaryStatistics statistics = users.stream().collect(Collectors.summarizingDouble(User::getId));
		
		System.out.println(statistics.getAverage());	//Promedio
		System.out.println(statistics.getMax());		//Máximo
		System.out.println(statistics.getMin());		//Mínimo
		System.out.println(statistics.getCount());		//Número de elementos
		System.out.println(statistics.getSum());		//Suma	
		
		//Alternativa para obtener summaryStatistics
		DoubleSummaryStatistics statistics1 = users.stream()
			.mapToDouble(User::getId)
			.summaryStatistics();
		
		System.out.println(statistics1.getAverage());	//Promedio
		System.out.println(statistics1.getMax());		//Máximo
		System.out.println(statistics1.getMin());		//Mínimo
		System.out.println(statistics1.getCount());		//Número de elementos
		System.out.println(statistics1.getSum());		//Suma	
		
		//partitioningBy
		System.out.println("======================== partitioningBy ========================");
		List<Integer> numeros = Arrays.asList(5, 7, 34, 56, 2, 3, 67, 4, 98);
		
		//divide la lista en 2 de acuerdo al predicado
		Map<Boolean, List<Integer>> esMayor = numeros.stream().collect(Collectors.partitioningBy(e -> e > 10));
		
		System.out.println("Mayor a 10");
		esMayor.get(true).stream().forEach(e->System.out.println(e));
		
		System.out.println("Menor a 10");
		esMayor.get(false).stream().forEach(e->System.out.println(e));
		
		//groupingBy
		System.out.println("======================== groupingBy ========================");
		setUpUser();
		
		//agrupamos por inicial
		Map<Character, List<User>> grupoAlfabetico = users.stream()
			.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		
		grupoAlfabetico.get('A').forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('M').forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('P').forEach(e -> System.out.println(e.getNombre()));
		
		//mapping
		System.out.println("======================== mapping ========================");
		setUpUser();
		
		//el nombre de cada usuario se coloca en una lista
		List<String> personas = users.stream().collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		personas.stream().forEach(e -> System.out.println(e));
		
		//Stream paralelo
		System.out.println("======================== Stream paralelo ========================");
		setUpUser();
		
		long tiempoStream = System.currentTimeMillis();
		lista.stream().forEach(e -> convertirAMayusculas(e));
		System.out.println("Normal: ".concat(Long.valueOf(System.currentTimeMillis()-tiempoStream).toString()));
		
		long tiempoStreamParalelo = System.currentTimeMillis();
		lista.parallelStream().forEach(e -> convertirAMayusculas(e));
		System.out.println("Paralelo: ".concat(Long.valueOf(System.currentTimeMillis()-tiempoStreamParalelo).toString()));
		
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
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
		users.stream().forEach(e -> System.out.println(e.toString()));
	}

}