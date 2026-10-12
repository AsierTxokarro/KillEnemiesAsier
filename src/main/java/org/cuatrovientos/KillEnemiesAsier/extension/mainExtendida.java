package org.cuatrovientos.KillEnemiesAsier.extension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import org.cuatrovientos.KillEnemiesAsier.Character;
import org.cuatrovientos.KillEnemiesAsier.Enemy;
import org.cuatrovientos.KillEnemiesAsier.Friend;

public class mainExtendida {
	static ArrayList<Character> caracters = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String leer;
		boolean seguirJugando = true;
		
		boolean partidaCargada = cargarPartida();
		if(!partidaCargada) {
			
			AnadirFriendsYSH();
			AnadirEnemiesYDN();
			Collections.shuffle(caracters);
			guardarPartida();
		}
		while(seguirJugando) {
			showCharacters();
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
			Character elegido = caracters.get(indicePersonaje);

			System.out.println("\nHas elegido el personaje " + indicePersonaje);

			// Identificamos el tipo de personaje
			if (elegido instanceof SuperHero) {
			    SuperHero sh = (SuperHero) elegido;

			    System.out.println("Has elegido un SuperHero.");
			    System.out.println("Vida actual: " + sh.getLife());
			    System.out.println("1. Atacar");
			    System.out.println("2. Pasar turno");

			} else if (elegido instanceof DarkNight) {
			    DarkNight dn = (DarkNight) elegido;

			    System.out.println("Has elegido un DarkNight.");
			    System.out.println("Vida actual: " + dn.getLife());
			    System.out.println("1. Atacar a un héroe");
			    System.out.println("2. Atacar a un amigo");
			    System.out.println("3. Pasar turno");

			} else if (elegido instanceof Enemy) {
			    System.out.println("Has elegido un enemigo normal.");
			    System.out.println("1. Atacar");
			    System.out.println("2. Pasar turno");

			} else if (elegido instanceof Friend) {
			    System.out.println("Has elegido un amigo.");
			    System.out.println("1. Curar");
			    System.out.println("2. Pasar turno");
			}

			// Leemos la acción
			System.out.println("Elige una acción:");
			leer = scanner.nextLine();

			int opcion;
			try {
			    opcion = Integer.parseInt(leer);
			} catch (NumberFormatException e) {
			    System.out.println("Debes introducir un número entero.");
			    continue;
			}

			// Procesamos la acción seleccionada
			switch (opcion) {
			case 1:
			    if (elegido instanceof SuperHero
			            || elegido instanceof DarkNight
			            || elegido instanceof Enemy) {

			        realizarAtaque(elegido, scanner);

			    } else if (elegido instanceof Friend) {
			        ((Friend) elegido).heal();
			    }
			    break;

			    case 2:
			        System.out.println("Has elegido pasar turno.");
			        break;

			    case 3:
			        if (elegido instanceof DarkNight) {
			            System.out.println("Has elegido pasar turno.");
			        } else {
			            System.out.println("Opción no válida para este personaje.");
			        }
			        break;

			    default:
			        System.out.println("Opción no válida.");
			        break;
			}
			
			showCharacters();
			System.out.println("¿Deseas continuar? (S/N)");
			leer = scanner.nextLine();
			if(!leer.equalsIgnoreCase("s")) {
				seguirJugando = false;
			}else {
				System.out.println("Continuamos");
			}
			
		}
		
	}
	
	
public static void AnadirFriendsYSH() {
		
		Friend f1 = new Friend();
		Friend f2 = new Friend();
		Friend f3 = new Friend();
		SuperHero sh1 = new SuperHero(100);
		SuperHero sh2 = new SuperHero(150);
		
		
		caracters.add(f1);
		caracters.add(f2);
		caracters.add(f3);
		caracters.add(sh1);
		caracters.add(sh2);
		
	}
	
	public static void AnadirEnemiesYDN() {
		
		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		Enemy e3 = new Enemy();
		DarkNight dn1 = new DarkNight(100);
		DarkNight dn2 = new DarkNight(150);
		
		caracters.add(e1);
		caracters.add(e2);
		caracters.add(e3);
		caracters.add(dn1);
		caracters.add(dn2);
		
	}
	
	public static void realizarAtaque(Character atacante, Scanner scanner) {

	    ArrayList<Integer> objetivos = new ArrayList<>();

	    // Mostramos los objetivos que puede atacar este personaje
	    for (int i = 0; i < caracters.size(); i++) {
	        Character objetivo = caracters.get(i);

	        if (objetivo == atacante) {
	            continue;
	        }

	        boolean valido = false;

	        if (atacante instanceof SuperHero) {
	            valido = objetivo instanceof Enemy;

	        } else if (atacante instanceof DarkNight) {
	            valido = objetivo instanceof SuperHero
	                    || objetivo instanceof Friend;

	        } else if (atacante instanceof Enemy) {
	            valido = objetivo instanceof Friend;
	        }

	        if (valido) {
	            objetivos.add(i);

	            System.out.println(
	                "Índice " + i + ": "
	                + obtenerNombre(objetivo)
	            );
	        }
	    }

	    if (objetivos.isEmpty()) {
	        System.out.println("No hay objetivos válidos.");
	        return;
	    }

	    // Pedimos el índice del objetivo
	    System.out.println("Introduce el índice del objetivo:");
	    String entrada = scanner.nextLine();

	    int indiceObjetivo;

	    try {
	        indiceObjetivo = Integer.parseInt(entrada);
	    } catch (NumberFormatException e) {
	        System.out.println("Debes introducir un número entero.");
	        return;
	    }

	    if (!objetivos.contains(indiceObjetivo)) {
	        System.out.println("El objetivo seleccionado no es válido.");
	        return;
	    }

	    Character objetivo = caracters.get(indiceObjetivo);

	    // Calculamos el daño
	    int damage = calcularDamage();

	    System.out.println(
	        obtenerNombre(atacante) + " ataca a "
	        + obtenerNombre(objetivo) + " y causa "
	        + damage + " puntos de daño."
	    );

	    // Aplicamos las reglas del combate
	    if (atacante instanceof SuperHero) {

	        if (objetivo instanceof DarkNight) {
	            DarkNight dn = (DarkNight) objetivo;
	            dn.receiveDamage(damage);

	            if (!dn.isAlive()) {
	                System.out.println("¡DarkNight ha muerto!");
	                caracters.remove(objetivo);
	            } else {
	                System.out.println(
	                    "Vida restante de DarkNight: " + dn.getLife()
	                );
	            }

	        } else if (objetivo instanceof Enemy) {
	            Enemy enemigo = (Enemy) objetivo;

	            // Reutilizamos el método de Hero.
	            ((SuperHero) atacante).attack(enemigo);

	            System.out.println("¡El enemigo ha muerto!");
	            caracters.remove(objetivo);
	        }

	    } else if (atacante instanceof DarkNight) {

	        if (objetivo instanceof SuperHero) {
	            SuperHero sh = (SuperHero) objetivo;
	            sh.receiveDamage(damage);

	            if (!sh.isAlive()) {
	                System.out.println("¡El SuperHero ha muerto!");
	                caracters.remove(objetivo);
	            } else {
	                System.out.println(
	                    "Vida restante del SuperHero: " + sh.getLife()
	                );
	            }

	        } else {
	            // Los héroes normales y los amigos no tienen vida
	            // en las clases originales: mueren de un ataque.
	            System.out.println(
	                "¡" + obtenerNombre(objetivo) + " ha muerto!"
	            );
	            caracters.remove(objetivo);
	        }
	    }

	    // Guardamos el estado actualizado
	    guardarPartida();
	}

	public static int calcularDamage() {
	    Random rnd = new Random();
	    return rnd.nextInt(1, 21); // Daño entre 1 y 20
	}

	public static String obtenerNombre(Character personaje) {

	    if (personaje instanceof SuperHero) {
	        return "SuperHero";
	    } else if (personaje instanceof DarkNight) {
	        return "DarkNight";
	    } else if (personaje instanceof Enemy) {
	        return "Enemy";
	    } else if (personaje instanceof Friend) {
	        return "Friend";
	    }

	    return "Personaje desconocido";
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
	public static void showCharacters() {
		for (int i = 0; i < caracters.size(); i++) {
		    Character c = caracters.get(i);

		    if (c instanceof DarkNight) {
		    	DarkNight dn = (DarkNight) c;
		        System.out.println("El personaje " + i + " es un DarkNight" + "y su vida es " + dn.getLife());
		    } else if (c instanceof SuperHero) {
		    	SuperHero sh = (SuperHero) c;
		        System.out.println("El personaje " + i + " es un SuperHero "+ sh.getLife());
		    } else if (c.isEnemy()) {
		        System.out.println("El personaje " + i + " es enemigo");
		    } else {
		        System.out.println("El personaje " + i + " es amigo");
		    }
		}
	}
	
	
	public int AttackDamage(int life) {
		Random rnd = new Random();
		int damage = rnd.nextInt(0, life);
		return damage;
	}
	
	//Método encargado de guardar el estado actual de la partida en un archivo
		public static void guardarPartida() {
			//ObjectOutputStream permite guardar objetos en el
		    try (ObjectOutputStream salida = new ObjectOutputStream(
		    		
		    		//FileOutputStream abre el archivo
		            new FileOutputStream("partida.dat"))) {

		        salida.writeObject(caracters);
		        System.out.println("Partida guardada correctamente.");

		    } catch (IOException e) {
		        System.out.println("Error al guardar la partida.");
		        //Muestra en la consola información detallada sobre un error ocurrido en el programa
		        e.printStackTrace();
		    }
		}
		
		//Método para cargar la partida
		@SuppressWarnings("unchecked")  // Evita el aviso del compilador por una conversión de tipo no comprobada.
		public static boolean cargarPartida() {
		    File archivo = new File("partida.dat");

		    if (!archivo.exists()) {
		        return false;
		    }
		    // si existe la partida lee el objeto guardado y lo convierte de nuevo en ArrayList<Character>
		    try (ObjectInputStream entrada = new ObjectInputStream(
		            new FileInputStream(archivo))) {

		        caracters = (ArrayList<Character>) entrada.readObject();
		        System.out.println("Partida cargada correctamente.");
		        return true;

		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("No se pudo cargar la partida.");
		        e.printStackTrace();
		        return false;
		    }
		}
}
