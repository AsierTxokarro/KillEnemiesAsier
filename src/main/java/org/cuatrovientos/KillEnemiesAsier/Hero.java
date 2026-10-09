package org.cuatrovientos.KillEnemiesAsier;


public class Hero implements Character{
	
	//atributos para contar los enemigos matados y los amigos defendidos
	int killed = 0;
	int defended = 0;
	
	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void attack(Enemy enemy) {
		killed ++;
		System.out.println("He atacado a un enemigo!");
		enemy.kill();
	}
	public void defend(Friend friend) {
		defended ++;
		System.out.println("¡He defendido a un amigo!");
	}
	public void contador() {
		System.out.println("Matados: "+ killed + " defendidos: "+ defended);
	}
	
}
