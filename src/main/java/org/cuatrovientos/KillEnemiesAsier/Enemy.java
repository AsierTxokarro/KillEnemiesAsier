package org.cuatrovientos.KillEnemiesAsier;

public class Enemy implements Character{

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return true;
	}
	public String kill() {
		return "Ahhggg, me mataste, bastardo!";
	}

}
