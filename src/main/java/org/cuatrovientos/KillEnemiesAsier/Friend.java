package org.cuatrovientos.KillEnemiesAsier;

public class Friend implements Character{

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return false;
	}
	public void heal() {
		System.out.println("¡Te he curado!");
	}

}
