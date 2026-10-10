package org.cuatrovientos.KillEnemiesAsier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Character> caracters = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String leer;
		boolean seguirJugando = true;
		AnadirFriends();
		AnadirEnemies();
		Collections.shuffle(caracters);
		while(seguirJugando) {
			int contador = 0;
			showCharacters();
			boolean HayEnemigos = false;
			for(Character c: caracters) {
				if(c.isEnemy()) {
					HayEnemigos = true;
				}
			}
			if(HayEnemigos) {
				System.out.println("Hay enemigos, puedes matarlos");
			}else {
				System.out.println("No hay enemigos, puedes si quieres sanar a tus amigos");
			}
			boolean opcionCorrecta = false;
			String opcionElegida = "";
			while(!opcionCorrecta) {
				
				System.out.println("¿Que quiere hacer el heroe? (Kill(K) o Heal(H))");
				leer = scanner.nextLine();
				if(comprobarSiLaOpcionElegidaEsCorrecta(leer) == false) {
					opcionCorrecta = false;
				}else{
					opcionCorrecta = true;
					opcionElegida = leer;
				};
			}
			int indicePersonaje = 0;
			boolean indiceCorrecto = false;
			while(!indiceCorrecto){
				System.out.println("Ahora elige el personaje en base a su indice");
				leer = scanner.nextLine();
				if(comprobarindiceCorrecto(leer) == false) {
					System.out.println("Debes introducir un número entero");
					indiceCorrecto = false;
				}else {
					indicePersonaje = Integer.parseInt(leer);
					indiceCorrecto = true;
				}
				
			}
			//Método para que el heroe mate o cure a un amigo o enemigo
			DecisionHeroe(opcionElegida,indicePersonaje);
			
			showCharacters();
			countCharacters();
				System.out.println("¿Deseas continuar? (S/N)");
				leer = scanner.nextLine();
				if(!leer.equalsIgnoreCase("s")) {
					seguirJugando = false;
				}else {
					System.out.println("El programa finalizara");
				}
				
		}
		
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
		for(int i = 0; i <= caracters.size() -1; i++) {
			if(caracters.get(i).isEnemy()) {
				System.out.println("El caracter "+ i + " es enemigo");
			}else {
				System.out.println("El caracter "+ i + " es amigo");
			}
		}
	}
	public static boolean comprobarSiLaOpcionElegidaEsCorrecta(String opcion) {
		if(opcion.equalsIgnoreCase("k") || opcion.equalsIgnoreCase("h")) {
			return true;
		}
		return false;
	}
	public static boolean comprobarindiceCorrecto(String opcion) {
		int indicePersonaje;
		try {
			indicePersonaje = Integer.parseInt(opcion);
			if(indicePersonaje < 0 || indicePersonaje > caracters.size() - 1) {
				return false;
			}
		}catch (NumberFormatException e){
			System.out.println("El indice es un número (Preferiblemente positivo y menor al tamaño de la lista");
			return false;
		}
		return true;
	}
	public static void DecisionHeroe(String opcion, int indice) {
		Hero h1 = new Hero();
		Character c = caracters.get(indice);
		if(opcion.equalsIgnoreCase("K")) {
			if(c.isEnemy()) {
				Enemy enemy = (Enemy) c;
				h1.attack(enemy);
				System.out.println("Enemigo eliminado");
			}else {
				System.out.println("¡Como has podido matar a un amigo, Traidor!");
				
			}
			caracters.remove(indice);
			
		}else {
			if(c.isEnemy()) {
				System.out.println("Como osas curar a un enemigo, ahora se multiplicara");
				Enemy e = new Enemy();
				caracters.add(e);
			}else {
				Friend friend = (Friend) c;
				friend.heal();
				
			}
		}
	}
}
