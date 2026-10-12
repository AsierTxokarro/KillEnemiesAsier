package org.cuatrovientos.KillEnemiesAsier.extension;

import org.cuatrovientos.KillEnemiesAsier.Enemy;

public class DarkNight extends Enemy implements Damageable{
int life;

public DarkNight(int life) {
	this.life = life;
	// TODO Auto-generated constructor stub
}

@Override
public void receiveDamage(int damage) {
	// TODO Auto-generated method stub
	life -= damage;
}

@Override
public int getLife() {
	// TODO Auto-generated method stub
	return life;
}

@Override
public boolean isAlive() {
	// TODO Auto-generated method stub
	if(this.life > 0) {
		return true;
	}else {
		return false;
	}
}

@Override
public boolean isSH() {
	// TODO Auto-generated method stub
	return false;
}

}
