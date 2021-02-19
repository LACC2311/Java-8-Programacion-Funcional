package com.lacc2311.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamPrueba {
	
	private static List<User> users;
	
	public static void main(String[] args) {
		
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

}
