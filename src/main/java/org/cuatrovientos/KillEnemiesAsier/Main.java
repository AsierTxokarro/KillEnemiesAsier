package org.cuatrovientos.KillEnemiesAsier;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static ArrayList<Character> caracters = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnadirFriends();
		AnadirEnemies();
		Collections.shuffle(caracters);
		int contador = 0;
		showCharacters();
		countCharacters();
	}
public static void AnadirFriends() {
		
		Friend f1 = new Friend();
		Friend f2 = new Friend();
		Friend f3 = new Friend();
		Friend f4 = new Friend();
		Friend f5 = new Friend();
		
		caracters.add(f1);
		caracters.add(f2);
		caracters.add(f3);
		caracters.add(f4);
		caracters.add(f5);
		
	}
	
	public static void AnadirEnemies() {
		
		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		Enemy e3 = new Enemy();
		Enemy e4 = new Enemy();
		Enemy e5 = new Enemy();
		
		caracters.add(e1);
		caracters.add(e2);
		caracters.add(e3);
		caracters.add(e4);
		caracters.add(e5);
		
	}
	public static void countCharacters() {
		int amigos = 0;
		int enemigos = 0;
		for(Character c: caracters) {
			if(c.isEnemy()) {
				enemigos ++;
			}else {
				amigos ++;
			}
		}
		System.out.println("Nº Enemigos: "+ enemigos + " Nº Amigos: "+ amigos);
	}
	public static void showCharacters() {
		for(int i = 0; i <= caracters.size(); i++) {
			if(caracters.get(i).isEnemy()) {
				System.out.println("El caracter "+ i + "es enemigo");
			}else {
				System.out.println("El caracter "+ i + " es amigo");
			}
		}
	}
}
