package org.cuatrovientos.KillEnemiesAsier.extension;

import java.util.ArrayList;
import java.util.Random;

import org.cuatrovientos.KillEnemiesAsier.Hero;

public class SuperHero extends Hero implements Damageable{

	private int life;

	public SuperHero(int life) {
		super();
		this.life = life;
	}
	@Override
	public void receiveDamage(int damage) {
		this.life -= damage;
		// TODO Auto-generated method stub
	}

	@Override
	public int getLife() {
		return life;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlife() {
		// TODO Auto-generated method stub
		if(this.life > 0) {
			return true;
		}else {
			return false;
		}
	}
	
}
